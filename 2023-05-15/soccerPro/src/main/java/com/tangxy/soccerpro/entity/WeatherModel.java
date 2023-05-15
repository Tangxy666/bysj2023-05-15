package com.tangxy.soccerpro.entity;


import lombok.Data;

import java.util.List;

/**
 * @Author: zjh
 * @Date: 2022/9/19 11:03
 * @Description: 天气总实体
 * @Version: v1.0
 */
@Data
public class WeatherModel {
    private String status;
    private String count;
    private String nfo;
    private String infocode;
    private List<LivesModel> lives;
}
