package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tinqibiao
 */
@TableName(value ="tinqibiao")
@Data
public class Tinqibiao implements Serializable {
    /**
     * 
     */
    private String cnusername;

    /**
     * 
     */
    private String adcode;

    /**
     * 
     */
    private String citycode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}