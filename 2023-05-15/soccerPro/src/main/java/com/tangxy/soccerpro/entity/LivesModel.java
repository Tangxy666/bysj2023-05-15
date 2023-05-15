package com.tangxy.soccerpro.entity;

import lombok.Data;

/**
 * @Author zjh
 * @Date 2022/9/19 1053
 * @Description 天气实体类
 * @Version v1.0
 */
@Data
public class LivesModel {
    private String province;
    private String city;
    private String adcode;
    private String weather ;
    private String temperature ;
    private String winddirection;
    private String windpower;
    private String humidity;
    private String reporttime ;
}
