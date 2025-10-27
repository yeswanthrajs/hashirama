package com.example.FoodOrder.controller;

import com.example.FoodOrder.DTO.FoodOrderDto;
import com.example.FoodOrder.DTO.UserDto;
import com.example.FoodOrder.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ControllerUser {

    @Autowired
    private UserService userService;


    @PostMapping("/save-user")
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        log.info("[Controller : save] - FoodOrder data entered - {}", userDto);
        UserDto savedData = userService.save(userDto);
        log.info("[Controller : save] - FoodOrder data Successfully entered : Im Exiting ");
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);

    }
}
