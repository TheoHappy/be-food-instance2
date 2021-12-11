package com.rtg.foodbackend2.controller;

import com.rtg.foodbackend2.dto.FoodDTO;
import com.rtg.foodbackend2.model.Food;
import com.rtg.foodbackend2.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        return new ResponseEntity<>(foodService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity<>(foodService.save(foodDTO),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFood(@RequestParam String uuid){
        foodService.delete(uuid);
        String message = String.format("Food with uuid %s was succesfully deleted",uuid);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Food> updateFood(@RequestParam String uuid, @RequestBody FoodDTO foodDto){
        return new ResponseEntity<>(foodService.update(uuid,foodDto),HttpStatus.OK);
    }

}

