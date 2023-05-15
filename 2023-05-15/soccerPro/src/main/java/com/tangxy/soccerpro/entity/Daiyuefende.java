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
 * @TableName dljltable
 */
@TableName(value ="dljltable")
@Data
public class Daiyuefende implements Serializable {
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
    private Date logintime;

    private Long dlcs;

    private String nianyuefen;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
