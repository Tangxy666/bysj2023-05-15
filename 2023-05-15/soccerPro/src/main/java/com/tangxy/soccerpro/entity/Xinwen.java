package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName xinwen
 */
@TableName(value ="xinwen")
@Data
public class Xinwen implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String biaoti;

    /**
     * 
     */
    private String fromwhere;

    /**
     * 
     */
    private Date fstime;

    /**
     * 
     */
    private String zwnr;

    private String imageurl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}