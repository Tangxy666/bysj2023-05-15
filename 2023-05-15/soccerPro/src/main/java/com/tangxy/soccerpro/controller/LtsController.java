package com.tangxy.soccerpro.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.component.WebSocketServer;
import com.tangxy.soccerpro.entity.*;
import com.tangxy.soccerpro.mapper.HaoyoutableMapper;
import com.tangxy.soccerpro.mapper.LtnrtableMapper;
import com.tangxy.soccerpro.mapper.PermsgMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Lts")
@CrossOrigin

public class LtsController {


    @Autowired
    HaoyoutableMapper haoyoutableMapper;

    @Autowired
    PermsgMapper permsgMapper;

    @Autowired
    LtnrtableMapper ltnrtableMapper;

    @Autowired
    WebSocketServer webSocketServer;




    @RequestMapping(value = "/LtsfindHaoyou" ,method = RequestMethod.POST)
    @ApiOperation("查找好友")
    public Result<List<Hyouxx>> LtsfindHaoyou(@RequestBody Logintable logintable){
        String username = logintable.getUsername();
        QueryWrapper<Haoyoutable> queryWrapper= new QueryWrapper<>();
        queryWrapper.like("ztun",username);
        List<Haoyoutable> haoyoutables = haoyoutableMapper.selectList(queryWrapper);
        List<String> l1=new ArrayList<>();
        for (Haoyoutable haoyoutable : haoyoutables) {
            l1.add(haoyoutable.getDfun());
        }
        System.out.println(l1);
        QueryWrapper<Permsg> queryWrapper2= new QueryWrapper<>();
        queryWrapper2.in("username",l1);
        List<Permsg> permsgs = permsgMapper.selectList(queryWrapper2);
        System.out.println(permsgs);
        List<Hyouxx> hyxx=new ArrayList<>();
        for(Permsg permsg:permsgs){
            hyxx.add(new Hyouxx(permsg.getUsername(),permsg.getImage()));
        }

        return Result.ok(hyxx);

    }

    @RequestMapping(value = "/LtsfindLtxingxi" ,method = RequestMethod.POST)
    @ApiOperation("查看聊天信息")
    public Result<List<Ltnrtable>> LtsfindLtxingxi(@RequestBody Haoyoutable haoyoutable){
        QueryWrapper<Ltnrtable> queryWrapper= new QueryWrapper<>();
        String benrenun=haoyoutable.getZtun();
        String duifan=haoyoutable.getDfun();
        System.out.println(benrenun+";"+duifan);

        queryWrapper.eq("xxfrom",benrenun).eq("xxto",duifan).or().eq("xxfrom",duifan).eq("xxto",benrenun);

        List<Ltnrtable> ltnrtables = ltnrtableMapper.selectList(queryWrapper);

        return Result.ok(ltnrtables);

    }

    @RequestMapping(value = "/LtssendMessage" ,method = RequestMethod.POST)
    @ApiOperation("发送聊天信息")
    public Result<Boolean> LtssendMessage(@RequestBody Ltnrtable ltnrtable){

        String xxfrom = ltnrtable.getXxfrom();
        String xxto = ltnrtable.getXxto();
        String context = ltnrtable.getContext();
        System.out.println(ltnrtable);
        Date fstime = new Date();


        boolean b = webSocketServer.userSfzx(xxto);
        System.out.println(b);
        if(b){
            System.out.println("在线！");
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("from", xxfrom);  // from 是 zhang
            jsonObject.set("text", context);  // text 同上面的text
            jsonObject.set("fstime", fstime);
            webSocketServer.sendMessage(jsonObject.toString(), webSocketServer.hqss(xxto));
            Ltnrtable ltnrtable1 = new Ltnrtable(null,xxfrom,xxto,context,fstime,0);
            ltnrtableMapper.insert(ltnrtable1);

        }
        else{
            Ltnrtable ltnrtable1 = new Ltnrtable(null,xxfrom,xxto,context,fstime,1);
            System.out.println("未在线！");
            ltnrtableMapper.insert(ltnrtable1);
        }

        return Result.ok();



    }

    @RequestMapping(value = "/Ltsxsx" ,method = RequestMethod.POST)
    @ApiOperation("发送聊天信息")
    public Result<List<Ltnrtable>> Ltsxsxywd(@RequestBody Ltnrtable ltnrtable) {

        QueryWrapper<Ltnrtable> objectQueryWrapper = new QueryWrapper<>();
        String xxto = ltnrtable.getXxto();
        objectQueryWrapper.eq("sfyd", 1).eq("xxto", xxto);
        List<Ltnrtable> ltnrtables = ltnrtableMapper.selectList(objectQueryWrapper);
        if (ltnrtables.isEmpty()) {
            System.out.println("没有未读消息");
            return Result.ok(null);
        } else {
            for (int i = 0; i < ltnrtables.size(); i++) {
                Ltnrtable ltnrtable1 = ltnrtables.get(i);
                ltnrtable1.setSfyd(0);
                ltnrtableMapper.updateById(ltnrtable1);

                System.out.println(ltnrtables);
            }
            return Result.ok(ltnrtables);

        }
    }





}
