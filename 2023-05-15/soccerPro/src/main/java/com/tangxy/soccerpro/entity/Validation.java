package com.tangxy.soccerpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Validation {
    private String code;
    private String email;
    private String password;
    private String userName;
    private String zhucecode;
}
