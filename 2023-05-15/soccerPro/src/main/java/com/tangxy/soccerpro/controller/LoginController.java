package com.tangxy.soccerpro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.*;
import com.tangxy.soccerpro.entity.Logintable;
import com.tangxy.soccerpro.mapper.HaoyoutableMapper;
import com.tangxy.soccerpro.mapper.LogintableMapper;
import com.tangxy.soccerpro.mapper.PermsgMapper;
import com.tangxy.soccerpro.service.MailService;
import com.tangxy.soccerpro.utils.JwtUtil;
import com.tangxy.soccerpro.utils.MD5;
import com.tangxy.soccerpro.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/loginRegister")
@CrossOrigin
public class LoginController {

    @Autowired
    RedisUtils redisUtils;



    // 用于发送邮件的对象
    @Autowired
    private MailService mailService;

    @Autowired
    LogintableMapper logintableMapper;

    @Autowired
    PermsgMapper permsgMapper;

    @Autowired
    HaoyoutableMapper haoyoutableMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("登录")
    public Result<Boolean> LoginConfirm(@RequestBody Logintable logintable, HttpServletRequest request, HttpServletResponse response){


        System.out.println(logintable);
        QueryWrapper<Logintable> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("username",logintable.getUsername()).eq("status",0);
        List<Logintable> logintables = logintableMapper.selectList(queryWrapper);
        System.out.println(logintables);
        if (logintables.isEmpty())
        {
            return Result.build(404,"输入的用户不存在");
        }
        else{
            Logintable loginu=logintables.get(0);
            System.out.println(loginu);
            if (!MD5.encrypt(logintable.getPassword()).equals(loginu.getPassword())) {
                System.out.println();
                return Result.build(404,"输入密码错误");
            }
        }

        HashMap<String, String> payload = new HashMap<>();
        payload.put("userName",logintable.getUsername());
        String token = JwtUtil.getToken(payload);
        response.setHeader("token",token);
        response.setHeader("Access-Control-Expose-Headers", "token");
        return Result.ok(true);
    }

    @ApiOperation("注册用户")
    @RequestMapping(value = "/zhuceLoginUser",method = RequestMethod.POST)
    public Result<Boolean> zhuceLoginUser(
            @RequestBody Validation validation
    ) throws ParseException {
        String passWord = validation.getPassword();
        String userName = validation.getUserName();
        String email = validation.getEmail();
        String inputcode = validation.getCode();
        System.out.println(passWord);
        System.out.println(userName);
        System.out.println(email);
        System.out.println(inputcode);
        String zhucecode = validation.getZhucecode();
        System.out.println(zhucecode);
//        Long id=1L;
        Long status= 0L;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formdate = sdf.parse(sdf.format(date));
        System.out.println(formdate);

        String newPassWord = MD5.encrypt(passWord);
        Logintable Oldtable=new Logintable(null,userName,newPassWord,email,status,formdate,zhucecode);

        Permsg permsg = new Permsg(userName,email,date,null,1L,null);
        Haoyoutable txy = new Haoyoutable(null,userName, "txy");
        Haoyoutable txy2 = new Haoyoutable(null,"txy", userName);


//        PersonalInformation personalInformation = new PersonalInformation();
//        personalInformation.setEmail(email);
//        personalInformation.setUserName(userName);
//
//        BodyMeasurementDto bodyMeasurementDto = new BodyMeasurementDto();
//        bodyMeasurementDto.setUserName(userName);
        System.out.println(userName);
        Object sendcode = (String) redisUtils.get(userName);


        QueryWrapper<Logintable> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("username",Oldtable.getUsername()).eq("status",0);
        List<Logintable> logintables = logintableMapper.selectList(queryWrapper);



        System.out.println(logintables);
        System.out.println(Oldtable);

        if(logintables.isEmpty()){
            if(!inputcode.equals(sendcode)){
                return Result.build(404,"验证码错误");
            }
            else {
                logintableMapper.insert(Oldtable);
                permsgMapper.insert(permsg);
                haoyoutableMapper.insert(txy);
                haoyoutableMapper.insert(txy2);


                System.out.println("插入成功");
//                personalInformationService.addUsername(personalInformation);
//                bodyMeasurementService.addByuserName(bodyMeasurementDto);
                return Result.ok();
            }
        }
        else{
            return Result.build(404,"用户名已经存在，无法注册");
        }

    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/uqdatemima",method = RequestMethod.POST)
    public Result<String> uqdatemima(@RequestBody Validation validation
    )
    {

        String email = validation.getEmail();
        String password = validation.getPassword();
        String inputCode = validation.getCode();
        System.out.println(email);



        QueryWrapper<Logintable> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("email",email);
        List<Logintable> logintables = logintableMapper.selectList(queryWrapper);
        System.out.println(logintables);

        if(logintables.isEmpty()){
            return Result.build(404,"邮箱未注册");
        }
        else {
            Logintable logintab=logintables.get(0);
            String userName = logintab.getUsername();
            String sendCode = (String) redisUtils.get(userName);
            if(inputCode.equals(sendCode)) {
                String newPassword = MD5.encrypt(password);
                logintab.setPassword(newPassword);
                logintableMapper.updateById(logintab);
                return Result.ok();
            }
            else{
                return Result.build(404,"验证码错误");
            }
        }
    }

    /**
     * 发送邮件
     * @param validation 各种信息
     * @return true 发送成功，否则发送失败
     */
    @RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    @ApiOperation("发送的邮箱验证码")
    public Result sendEmailCode(@RequestBody Validation validation) {

        String email = validation.getEmail();
        String userName = validation.getUserName();
        System.out.println(validation);
        try {
            ArrayList<String> youxiangliebiao = new ArrayList<>();
            youxiangliebiao.add(email);
            String code=String.valueOf((int)((Math.random()*9+1)*100000));
            EmailDto emailDto = new EmailDto();
            emailDto.setTos(youxiangliebiao);
            emailDto.setSubject("验证码");
            emailDto.setContent("验证码为"+code);
            mailService.sendMail(emailDto);
            redisUtils.set(userName,code,180L);
            System.out.println("写入redis成功");
            return Result.ok();
        } catch (Exception e) {
            // 发送过程中，发生错误，打印错误信息，返回false
            e.printStackTrace();
            return Result.build(404,"邮箱不存在");
        }
    }

}
