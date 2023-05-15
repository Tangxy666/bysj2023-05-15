package com.tangxy.soccerpro.mapper;

import com.tangxy.soccerpro.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86191
* @description 针对表【car】的数据库操作Mapper
* @createDate 2023-04-25 14:25:47
* @Entity com.tangxy.soccerpro.entity.Car
*/
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}




