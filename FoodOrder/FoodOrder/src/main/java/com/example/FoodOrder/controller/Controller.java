package com.example.FoodOrder.controller;

import com.example.FoodOrder.DTO.FoodOrderDto;
import com.example.FoodOrder.Service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private FoodService foodService;

    @PostMapping("/save-Food-Orders")
    public ResponseEntity<?> save(@RequestBody FoodOrderDto foodOrderDto) {
        log.info("[Controller : save] - FoodOrder data entered - {}", foodOrderDto);
        FoodOrderDto savedData = foodService.save(foodOrderDto);
        log.info("[Controller : save] - FoodOrder data Successfully entered : Im Exiting ");
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);

    }

    @GetMapping("/get-Food-Orders")
    public ResponseEntity<?> getFoodOrder(@RequestParam int FoodOrderId){
        log.info("[Controller : getFoodOrder] - FoodOrder data Getting - {}",FoodOrderId);
        FoodOrderDto foodOrderDto = foodService.getFoodOrder(FoodOrderId);
        log.info("[Controller : getFoodOrder] - FoodOrder data Getting Successfully {} : Im Exiting ",foodOrderDto);
        return new ResponseEntity<FoodOrderDto>(foodOrderDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-Food-Orders")
    public ResponseEntity<String> deleteFoodOrder(@RequestParam int FoodOrderId){
        log.info("[Controller : deleteFoodOrder] - FoodOrder data Deleting - {}",FoodOrderId);
        String foodOrderDto = foodService.deleteFoodOrder(FoodOrderId);
        log.info("[Controller : deleteFoodOrder] - FoodOrder data Deleting Successfully : Im Exiting ");
        return new ResponseEntity<>(foodOrderDto, HttpStatus.CREATED);
    }

    @PatchMapping("/update-Food-Orders")
    public ResponseEntity<?> updateFoodOrder(@RequestParam int FoodOrderId, String FoodOrderName){
        log.info("[Controller : updateFoodOrder] - FoodOrder data Updating -id: {}  name: {}",FoodOrderId,FoodOrderName);
        FoodOrderDto foodOrderDto = foodService.updateFoodOrder(FoodOrderId,FoodOrderName);
        log.info("[Controller : updateFoodOrder] - FoodOrder data Updating Successfully : Im Exiting ");
        return new ResponseEntity<>(foodOrderDto,HttpStatus.UPGRADE_REQUIRED);
    }

    @PutMapping("/updateAll-Food-Orders")
    public ResponseEntity<?> updateAllFoodOrder(@RequestParam int FoodOrderId,@RequestBody FoodOrderDto foodOrderDto){
        log.info("[Controller : updateAll] - FoodOrder data Updating All - id: {}    FoodOrder: {}",FoodOrderId,foodOrderDto);
        FoodOrderDto foodOrderDto1 = foodService.updateAllFoodOrder(FoodOrderId, foodOrderDto);
        log.info("[Controller : updateAll] - FoodOrder data Updating All Successfully : Im Exiting ");
        return new ResponseEntity<>(foodOrderDto1, HttpStatus.UPGRADE_REQUIRED);
    }

    @GetMapping("/getAll-Food-Orders")
    public ResponseEntity<?> getAllFoodOrder(){
        log.info("[Controller : getAll] - FoodOrder data Getting All ");
        List<FoodOrderDto> foodOrderDto = foodService.getAllFoodOrder();
        log.info("[Controller : getAll] - FoodOrder data Updating All Successfully : Im Exiting ");
        return new ResponseEntity<>(foodOrderDto,HttpStatus.FOUND);
    }

    @GetMapping("/Discount-Food-Orders")
    public ResponseEntity<String> getUserOrders(@RequestParam int userId,@RequestParam int foodOrderId){
        String foodOrderDto = foodService.getUserOrders(userId,foodOrderIdderId);
        return new ResponseEntity<>(foodOrderDto, HttpStatus.CREATED);
    }


}
