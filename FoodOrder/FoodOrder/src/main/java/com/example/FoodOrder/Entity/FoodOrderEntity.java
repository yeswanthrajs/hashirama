package com.example.FoodOrder.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class FoodOrderEntity {
    @Id
    private int foodOrder_id;
    private String foodOrder_name;
    private double foodOrder_price;
    private int foodOrder_quantity;

    @OneToOne
    private UserEntity user;

}
