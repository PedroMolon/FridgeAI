package com.pedromolon.fridgeai.controller;

import com.pedromolon.fridgeai.dto.request.FoodItemRequest;
import com.pedromolon.fridgeai.dto.response.FoodItemResponse;
import com.pedromolon.fridgeai.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public ResponseEntity<List<FoodItemResponse>> getAllFoods() {
        return ResponseEntity.status(HttpStatus.OK).body(foodItemService.getAllFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemResponse> getFoodById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(foodItemService.getFoodById(id));
    }

    @PostMapping
    public ResponseEntity<FoodItemResponse> saveFood(@RequestBody @Valid FoodItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodItemService.saveFood(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItemResponse> updateFood(@PathVariable Long id, @RequestBody @Valid FoodItemRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(foodItemService.updateFood(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodItemService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }

}
