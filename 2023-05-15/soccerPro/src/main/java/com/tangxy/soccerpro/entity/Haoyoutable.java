package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName haoyoutable
 */
@TableName(value ="haoyoutable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Haoyoutable implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String ztun;

    /**
     * 
     */
    private String dfun;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}