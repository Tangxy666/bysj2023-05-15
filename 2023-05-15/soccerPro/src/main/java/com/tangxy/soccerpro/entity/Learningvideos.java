package com.tangxy.soccerpro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName learningvideos
 */
@TableName(value ="learningvideos")
@Data
public class Learningvideos implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String label;

    /**
     * 
     */
    private Long parent;

    /**
     * 
     */
    private Integer sfsvideo;

    /**
     * 
     */
    private String videourl;

    List<Learningvideos> children;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}