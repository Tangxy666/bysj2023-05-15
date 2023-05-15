package com.tangxy.soccerpro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.Hyouxx;
import com.tangxy.soccerpro.entity.Logintable;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.entity.Xinwen;
import com.tangxy.soccerpro.mapper.XinwenMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hqxw")
@CrossOrigin
public class Hqxwcontroller {



    @Autowired
    XinwenMapper xinwenMapper;


    @RequestMapping(value = "/Findxinwen" ,method = RequestMethod.POST)
    @ApiOperation("查找新闻")
    public Result<List<Xinwen>> Findxinwen(@RequestBody Xinwen xinwen){

        QueryWrapper<Xinwen> objectQueryWrapper = new QueryWrapper<>();
        if(xinwen.getFromwhere()==null && xinwen.getId()!=null){
            objectQueryWrapper.eq("id",xinwen.getId());

        }
        else {
            objectQueryWrapper.eq("fromwhere", xinwen.getFromwhere());
        }
        List<Xinwen> xinwens = xinwenMapper.selectList(objectQueryWrapper);
        return Result.ok(xinwens);


    }
}
