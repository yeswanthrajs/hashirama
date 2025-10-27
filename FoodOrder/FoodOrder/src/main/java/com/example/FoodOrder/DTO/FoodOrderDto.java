package com.example.FoodOrder.DTO;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;


@Data
public class FoodOrderDto {
    private int foodOrder_id;
    private String foodOrder_name;
    private double foodOrder_price;
    private int foodOrder_quantity;

    private UserDto userDto;
}
