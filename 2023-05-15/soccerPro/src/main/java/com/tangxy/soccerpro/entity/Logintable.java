package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName logintable
 */
@TableName(value ="logintable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logintable implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Long status;

    /**
     * 
     */
    private Date zhucetime;

    /**
     * 
     */
    private String zhucecode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}