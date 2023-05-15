package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName wenzhangtable
 */
@TableName(value ="wenzhangtable")
@Data
public class Wenzhangtable implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String biaoti;

    /**
     * 
     */
    private String bfnr;

    /**
     * 
     */
    private String zwnr;

    /**
     * 
     */
    private String fstime;

    /**
     * 
     */
    private String fromwhere;

    /**
     * 
     */
    private String imageurl;

    /**
     * 
     */
    private Long dianzanshu;

    /**
     * 
     */
    private Long liulanlian;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}