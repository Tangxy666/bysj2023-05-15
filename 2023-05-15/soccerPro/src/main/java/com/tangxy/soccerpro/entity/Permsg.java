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
 * @TableName permsg
 */
@TableName(value ="permsg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permsg implements Serializable {
    /**
     * 
     */
    @TableId
    private String username;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Date zhucetime;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private Long numofhy;

    /**
     * 
     */
    private String mydescribe;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}