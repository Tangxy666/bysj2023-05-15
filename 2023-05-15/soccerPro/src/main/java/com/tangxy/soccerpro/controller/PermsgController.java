package com.tangxy.soccerpro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.Daiyuefende;
import com.tangxy.soccerpro.entity.Dljltable;
import com.tangxy.soccerpro.entity.Permsg;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.mapper.DljltableMapper;
import com.tangxy.soccerpro.mapper.PermsgMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Permsg")
@CrossOrigin
public class PermsgController {


    @Autowired
    PermsgMapper permsgMapper;

    @Autowired
    DljltableMapper dljltableMapper;

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    @ApiOperation("获取个人信息")
    public Result<Permsg> FindPermsg(@RequestBody Permsg permsg){

        System.out.println(permsg);
        QueryWrapper<Permsg> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("username",permsg.getUsername());
        List<Permsg> permsgs = permsgMapper.selectList(queryWrapper);
        System.out.println(permsgs);

        if(!permsgs.isEmpty()){
            return Result.ok(permsgs.get(0));
        }
        else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/finddlxxsj",method = RequestMethod.POST)
    @ApiOperation("获取登录信息")
    public Result<List<Dljltable>> Finddlxxsj(@RequestBody Daiyuefende daiyuefende){

        String username = daiyuefende.getUsername();
        String nianyuefen = daiyuefende.getNianyuefen();
        String month = nianyuefen.split("-")[1];
        System.out.println(month);
        QueryWrapper<Dljltable> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username",username);
        if(Integer.parseInt(month)<10){
            objectQueryWrapper.like("logintime","-0"+month+"-").groupBy("logintime")
            .orderByAsc("logintime");
        }
        else{
            objectQueryWrapper.like("logintime","-"+month+"-").groupBy("logintime")
                    .orderByAsc("logintime");
        }
        objectQueryWrapper.select("username,logintime, count(1) as dlcs");

        List<Dljltable> dljltables = dljltableMapper.selectList(objectQueryWrapper);
        System.out.println(dljltables);
        return Result.ok(dljltables);

    }


}
