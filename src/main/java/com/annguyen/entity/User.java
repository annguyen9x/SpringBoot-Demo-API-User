package com.annguyen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter// dùng lombok tự generate hàm getter, setter khi build (tức khi project đóng gói thành file jar)
@Getter// lombok tự generate hàm getter, setter
@AllArgsConstructor//Lombok tạo hàm k/tạo có tham số là tất cả các thuộc tính
@NoArgsConstructor//lombok tạo hàm construc không có tham số
public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;
}