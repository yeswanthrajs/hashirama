package com.example.FoodOrder.Repository;

import com.example.FoodOrder.Entity.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity, Integer> {

}
