package com.example.FoodOrder.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {
        @Id
        private int user_id;
        private String user_name;

        @OneToOne
        private FoodOrderEntity foodOrderEntity;


}
