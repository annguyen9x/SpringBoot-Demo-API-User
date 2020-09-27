package com.annguyen.service;

import com.annguyen.model.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUsers(String keyword);
}
