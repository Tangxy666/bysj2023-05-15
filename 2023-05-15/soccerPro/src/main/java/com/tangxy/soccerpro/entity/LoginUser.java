package com.tangxy.soccerpro.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUser {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private Long status;
    private Date zhuceTime;
    private String zhucecode;
}
