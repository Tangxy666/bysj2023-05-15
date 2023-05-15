package com.tangxy.soccerpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto implements Serializable {

    /**
     * 发送邮箱列表
     */
    //@NotEmpty
    private List<String> tos;

    /**
     * 主题
     */
    //@NotBlank
    private String subject;

    /**
     * 内容
     */
    //@NotBlank
    private String content;
}
