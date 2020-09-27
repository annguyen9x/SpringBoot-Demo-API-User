package com.annguyen.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Package "model.dto": định nghĩa cấu trúc trả về cho Client khác với cấu trúc các table trong DB
// (tức là các Object trả về khác Object Entity[Ánh xạ DB]), => ở đây nó không trả về Passworld
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
