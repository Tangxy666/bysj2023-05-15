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
public class LoginHasTokenUser {

    private String userName;
    private String passWord;
    private String token;
}
