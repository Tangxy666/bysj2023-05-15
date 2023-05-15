package com.tangxy.soccerpro.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangxy.soccerpro.entity.Car;
import com.tangxy.soccerpro.mapper.CarMapper;
import com.tangxy.soccerpro.service.CarService;
import org.springframework.stereotype.Service;

/**
* @author 86191
* @description 针对表【car】的数据库操作Service实现
* @createDate 2023-04-25 14:25:47
*/
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{

}




