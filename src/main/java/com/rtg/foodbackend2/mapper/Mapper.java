package com.rtg.foodbackend2.mapper;


import com.rtg.foodbackend2.dto.FoodDTO;
import com.rtg.foodbackend2.model.Food;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Food convertDtoToModel(FoodDTO foodDTO) {
        return Food.builder()
                .name(foodDTO.getName())
                .proteins(foodDTO.getProteins())
                .fats(foodDTO.getFats())
                .carbohydrates(foodDTO.getCarbohydrates())
                .build();
    }

    public FoodDTO convertModelToDto(Food food) {
        return FoodDTO.builder()
                .name(food.getName())
                .carbohydrates(food.getCarbohydrates())
                .fats(food.getFats())
                .proteins(food.getProteins())
                .build();
    }
}
