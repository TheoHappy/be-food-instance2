package com.rtg.foodbackend2.service;

import com.rtg.foodbackend2.dto.FoodDTO;
import com.rtg.foodbackend2.mapper.Mapper;
import com.rtg.foodbackend2.model.Food;
import com.rtg.foodbackend2.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final Mapper mapper;

    public List<Food> getAll() {
        return this.foodRepository.findAll();
    }

    public Food save(FoodDTO foodDTO) {
        Food food = mapper.convertDtoToModel(foodDTO);
        food.setUuid(getUUID());
        return this.foodRepository.save(food);
    }

    public Food update(String uuid, FoodDTO foodDTO) {
        Food food;
        if (isPresent(uuid)) {
            food = foodRepository.findById(uuid).get();
            food.setName(foodDTO.getName());
            food.setProteins(foodDTO.getProteins());
            food.setCarbohydrates(foodDTO.getCarbohydrates());
            food.setFats(foodDTO.getFats());
        }else {
            throw new RuntimeException(String.format("Food with uuid[%s] is not present in db",uuid));
        }
        return this.foodRepository.save(food);
    }

    public void delete(String uuid) {
        foodRepository
                .delete(foodRepository.getById(uuid));
    }

    public boolean isPresent(String uuid) {
        Optional<Food> foodOptional = foodRepository.findById(uuid);
        if (foodOptional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public String getUUID() {
        String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 22));
        return uuid.substring(uuid.length() - 22);
    }
}
