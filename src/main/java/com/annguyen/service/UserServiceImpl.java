package com.annguyen.service;

import com.annguyen.entity.User;
import com.annguyen.exception.NotFoundException;
import com.annguyen.model.dto.UserDto;
import com.annguyen.model.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //Giả sử tạo DB User dạng ArrayList
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "hinh1.png", "abc"));
        users.add(new User(2, "Hồ Thị Thúy", "thuyho@gmail.com", "0987677819", "hinh2.png", "abc"));
        users.add(new User(3, "Lê Văn Tèo", "teole@gmail.com", "0988876556", "hinh3.png", "abc"));
        users.add(new User(4, "Bùi Ái Phương", "aiphuong@gmail.com", "0977745320", "hinh4.png", "abc"));

    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: users){
            userDtos.add(UserMapper.toUserDto(user));
        }

        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user: users){
            if(user.getId() == id ){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUsers(String keyword) {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: users){
            if(user.getName().contains(keyword)){//contains: hàm tìm kiếm chỉ cần có từ khóa trong chuỗi trả về true
                userDtos.add(UserMapper.toUserDto(user));
            }
        }
        return userDtos;
    }
}
