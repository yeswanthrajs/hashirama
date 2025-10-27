package com.example.FoodOrder.ServiceImple;

import com.example.FoodOrder.DTO.FoodOrderDto;
import com.example.FoodOrder.Entity.FoodOrderEntity;
import com.example.FoodOrder.Repository.FoodOrderRepository;
import com.example.FoodOrder.Service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodOrderRepository repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public FoodOrderDto save(FoodOrderDto foodOrderDto) {
        FoodOrderEntity entity = repo.save(convertDtoToEntity(foodOrderDto));
        return convertEntityToDto(entity);
    }

    @Override
    public FoodOrderDto getFoodOrder(int foodOrderId){
        Optional<FoodOrderEntity> o =  repo.findById(foodOrderId);
        if (o.isPresent()){
            FoodOrderEntity foodOrderEntity = o.get();
            System.out.println("[getFoodOrder]");
            return convertEntityToDto(foodOrderEntity);
        }
        else
            return null;
    }

    @Override
    public String deleteFoodOrder(int id){
        FoodOrderDto p = getFoodOrder(id);
        if(p != null){
            repo.delete(convertDtoToEntity(p));
            return "Successfully Deleted";
        }
        else
            return "Data not Found";
    }

    @Override
    public FoodOrderDto updateFoodOrder( int id ,String name){
        FoodOrderDto p = getFoodOrder(id);
        if(p!= null){
            p.setFoodOrder_name(name);
            FoodOrderEntity entity = repo.save(convertDtoToEntity(p));
            return convertEntityToDto(entity);
        }
        else {
            return null;
        }
    }

    @Override
    public FoodOrderDto updateAllFoodOrder(int id, FoodOrderDto fod){
        FoodOrderDto p = getFoodOrder(id);

        if(p!= null){
            p.setFoodOrder_name(fod.getFoodOrder_name());
            p.setFoodOrder_price(fod.getFoodOrder_price());
            p.setFoodOrder_quantity(fod.getFoodOrder_quantity());
            return convertEntityToDto(repo.save(convertDtoToEntity(p)));

        }
        else
            return null;
    }

    @Override
    public List<FoodOrderDto> getAllFoodOrder() {
        return repo.findAll().stream().map(this::convertEntityToDto).toList();
    }


    @Override
    public String getUserOrders(int userId, int foodOrderId) {
        FoodOrderDto foodOrderDto = getFoodOrder(foodOrderId);
        double price = foodOrderDto.getFoodOrder_price();

        double discountPrice = 0, firstUserDiscount = 0;
        if (!userIds.contains(userId)) {
            userIds.add(userId);
            firstUserDiscount = price * 0.15;
        }

        discountPrice = (price >= 200 && price <= 400) ? price * 0.05 : ((price >= 400) ? price * 0.1 : 0);

        return "Total Price : "+  (price-(firstUserDiscount+discountPrice));

    }





    List<Integer> userIds = new ArrayList<>();



    public FoodOrderEntity convertDtoToEntity(FoodOrderDto foodOrderDto) {
        return modelMapper.map(foodOrderDto, FoodOrderEntity.class);
    }

    public FoodOrderDto convertEntityToDto(FoodOrderEntity foodOrderEntity) {
        return modelMapper.map(foodOrderEntity, FoodOrderDto.class);
    }
}
