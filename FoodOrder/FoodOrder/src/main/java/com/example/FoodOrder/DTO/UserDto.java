package com.example.FoodOrder.DTO;

import com.example.FoodOrder.Entity.FoodOrderEntity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class UserDto {

    @Id
    private int user_id;
    private String user_name;

    private FoodOrderDto foodOrderDto;

}
