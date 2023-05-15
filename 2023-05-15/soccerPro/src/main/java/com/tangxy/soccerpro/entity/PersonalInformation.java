package com.tangxy.soccerpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalInformation {
    private Long id;
    private String userName;
    private String email;
    private String teamCode;
    private String postCode;
}
