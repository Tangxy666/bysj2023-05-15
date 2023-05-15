package com.tangxy.soccerpro.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.*;
import com.tangxy.soccerpro.mapper.TinqibiaoMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tianqi")
@CrossOrigin
public class TianqiController {

    @Autowired
    TinqibiaoMapper tinqibiaoMapper;



    @RequestMapping(value = "/findtianqi" ,method = RequestMethod.POST)
    @ApiOperation("查看指定城市天气")
    public Result<JSONObject> findtianqi(@RequestBody LivesModel livesModel){
        String srcity = livesModel.getCity();
        QueryWrapper<Tinqibiao> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("cnusername",srcity);
        List<Tinqibiao> tinqibiaos = tinqibiaoMapper.selectList(objectQueryWrapper);
        String adcode = tinqibiaos.get(0).getAdcode();

        System.out.println(adcode);
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=6906121ea53aee65b8a68b213bcbef59&city="+adcode+"&extensions=all";
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(mediaType);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        String s = result;
        System.out.println(s);
        JSONObject object = JSONObject.parseObject(s);
        return Result.ok(object);
    }

    @RequestMapping(value = "/findtianqishishi" ,method = RequestMethod.POST)
    @ApiOperation("查看指定城市实时天气")
    public Result<JSONObject> findtianqishishi(@RequestBody LivesModel livesModel){
        String srcity = livesModel.getCity();
        QueryWrapper<Tinqibiao> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("cnusername",srcity);
        List<Tinqibiao> tinqibiaos = tinqibiaoMapper.selectList(objectQueryWrapper);
        String adcode = tinqibiaos.get(0).getAdcode();
        System.out.println(adcode);
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=6906121ea53aee65b8a68b213bcbef59&city="+adcode;
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(mediaType);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        String s = result;
        System.out.println(s);
        JSONObject object = JSONObject.parseObject(s);
        return Result.ok(object);
    }
}
