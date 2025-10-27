package com.example.FoodOrder.Service;

import com.example.FoodOrder.DTO.FoodOrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodService {

    public FoodOrderDto save(FoodOrderDto foodOrderDto);

   public FoodOrderDto getFoodOrder(int p);

   public String deleteFoodOrder(int id);

    public FoodOrderDto updateFoodOrder(int id, String name);

    public FoodOrderDto updateAllFoodOrder(int id, FoodOrderDto foodOrderDto);

    public List<FoodOrderDto> getAllFoodOrder();

    public String getUserOrders(int userId, int foodOrderId);
}
