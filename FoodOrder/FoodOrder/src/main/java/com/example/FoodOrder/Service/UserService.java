package com.example.FoodOrder.Service;

import com.example.FoodOrder.DTO.FoodOrderDto;
import com.example.FoodOrder.DTO.UserDto;

import java.util.List;

public interface UserService {

    public UserDto save(UserDto userDto);

    public UserDto getUser(int p);

    public String deleteUser(int id);

    public UserDto updateUser(int id, String name);

    public UserDto updateAllUser(int id, UserDto userDto);

    public List<UserDto> getAllUser();
}
