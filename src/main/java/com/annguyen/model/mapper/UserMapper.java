package com.annguyen.model.mapper;

import com.annguyen.entity.User;
import com.annguyen.model.dto.UserDto;

//Package "model.mapper" Chứa các hàm convert(chuyển đổi) từ Entitty (User-Ánh xạ DB)
// sang Dto (User - các trường dữ liệu trả về cho client sẽ khác trong DB)
public class UserMapper {

    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();

        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());

        return tmp;
    }
}
