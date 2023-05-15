package com.tangxy.soccerpro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangxy.soccerpro.entity.Car;
import com.tangxy.soccerpro.entity.Learningvideos;
import com.tangxy.soccerpro.entity.PageCar;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.mapper.LearningvideosMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/LearningVideo")
@CrossOrigin



public class LearningVideoController {


    @Autowired
    LearningvideosMapper learningvideosMapper;

    @RequestMapping(value = "/videofindALL" ,method = RequestMethod.GET)
    @ApiOperation("查看所有二手车")
    public Result<List<Learningvideos>> VideofindALL(){

        QueryWrapper<Learningvideos> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("parent", 0);
        List<Learningvideos> learningvideos = learningvideosMapper.selectList(objectQueryWrapper);
        if (learningvideos != null && learningvideos.size() > 0) {
            learningvideos.forEach(this::findAllChild);
        }
        return Result.ok(learningvideos);
    }

    public void findAllChild( Learningvideos learningvideos ) {
        QueryWrapper<Learningvideos> wrapper = new QueryWrapper<>();
        wrapper.eq("parent", learningvideos.getId());
        // 首次进入这个方法时，查出的是二级节点列表
        // 递归调用时，就能依次查出三、四、五等等级别的节点列表，
        // 递归能实现不同节点级别的无限调用,这个层次不易太深，否则有性能问题
        List<Learningvideos> resources = learningvideosMapper.selectList(wrapper);
        learningvideos.setChildren(resources);
        if (resources != null && resources.size() > 0) {
            resources.forEach(this::findAllChild);
        }
    }




}
