package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName car
 */
@TableName(value ="car")
@Data
public class Car implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String vehiclemodel;

    /**
     * 
     */
    private String carcondition;

    /**
     * 
     */
    private String pricecar;

    /**
     * 
     */
    private String originalprice;

    /**
     * 
     */
    private String carmapaddress;

    /**
     * 
     */
    private String state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}