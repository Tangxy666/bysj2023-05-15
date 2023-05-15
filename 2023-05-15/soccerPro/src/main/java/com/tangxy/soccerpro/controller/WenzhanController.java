package com.tangxy.soccerpro.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.LivesModel;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.entity.Wenzhangtable;
import com.tangxy.soccerpro.mapper.WenzhangtableMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wenzhan")
@CrossOrigin
public class WenzhanController {

    @Autowired
    WenzhangtableMapper wenzhangtableMapper;


    @RequestMapping(value = "/findwenzhan" ,method = RequestMethod.GET)
    @ApiOperation("查看文章")
    public Result<List<Wenzhangtable>> findwenzhan(){

        QueryWrapper<Wenzhangtable> wenzhangtableQueryWrapper = new QueryWrapper<>();
        List<Wenzhangtable> wenzhangtables = wenzhangtableMapper.selectList(wenzhangtableQueryWrapper);
        return Result.ok(wenzhangtables);
    }

    @RequestMapping(value = "/findwenzhanbyid" ,method = RequestMethod.POST)
    @ApiOperation("查看文章")
    public Result<List<Wenzhangtable>> findwenzhanbyid(@RequestBody Wenzhangtable wenzhangtable){

        QueryWrapper<Wenzhangtable> wenzhangtableQueryWrapper = new QueryWrapper<>();
        Long id = wenzhangtable.getId();
        wenzhangtableQueryWrapper.eq("id",id);
        List<Wenzhangtable> wenzhangtables = wenzhangtableMapper.selectList(wenzhangtableQueryWrapper);
        return Result.ok(wenzhangtables);
    }

}
