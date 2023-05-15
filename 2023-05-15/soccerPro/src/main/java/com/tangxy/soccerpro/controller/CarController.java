package com.tangxy.soccerpro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tangxy.soccerpro.entity.Car;
import com.tangxy.soccerpro.entity.PageCar;
import com.tangxy.soccerpro.entity.Result;
import com.tangxy.soccerpro.mapper.CarMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car")
@CrossOrigin
public class CarController {


    @Autowired
    CarMapper carMapper;

    @RequestMapping(value = "/carfindALL" ,method = RequestMethod.POST)
    @ApiOperation("查看所有二手车")
    public Result<List<Car>> LoginConfirm(@RequestBody PageCar pageCar){

        String vehiclemodel = pageCar.getVehiclemodel();
        String address = pageCar.getAddress();


        System.out.println(pageCar);
        Long pagenew = pageCar.getPagenew();
        Page<Car> page = new Page<>(pagenew, 4);


        QueryWrapper<Car> queryWrapper= new QueryWrapper<>();
        if (address!=null){
            queryWrapper.like("carcondition",address);
        }

        if (vehiclemodel!=null){
            queryWrapper.like("vehiclemodel",vehiclemodel);
        }

        Page<Car> iPage = carMapper.selectPage(page,queryWrapper);

        System.out.println("数据总条数："+iPage.getTotal());
        System.out.println("数据总页数："+iPage.getPages());
        System.out.println("当前的页数："+iPage.getCurrent());

        List<Car> cars = iPage.getRecords();

        System.out.println(cars);


        if(cars!=null){

            Result<List<Car>> ok = Result.ok(cars);
            ok.setMessage(String.valueOf(iPage.getTotal()));

            return ok;
        }
        else{
            return Result.fail();
        }
    }

}
