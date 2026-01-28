package com.pedromolon.fridgeai.service;

import com.pedromolon.fridgeai.dto.request.FoodItemRequest;
import com.pedromolon.fridgeai.dto.response.FoodItemResponse;
import com.pedromolon.fridgeai.mapper.FoodItemMapper;
import com.pedromolon.fridgeai.model.FoodItem;
import com.pedromolon.fridgeai.repository.FoodItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public List<FoodItemResponse> getAllFoods() {
        return foodItemRepository.findAll()
                .stream()
                .map(foodItemMapper::toResponse)
                .toList();
    }

    public FoodItemResponse getFoodById(Long id) {
        return foodItemMapper.toResponse(
                foodItemRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Food not found with id: " + id))
        );
    }

    public FoodItemResponse saveFood(FoodItemRequest request) {
        return foodItemMapper.toResponse(
                foodItemRepository.save(foodItemMapper.toEntity(request))
        );
    }

    public FoodItemResponse updateFood(Long id, FoodItemRequest request) {
        FoodItem foodItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Food not found with id: " + id));

        foodItem.setName(request.name());
        foodItem.setQuantity(request.quantity());
        foodItem.setCategory(request.category());
        foodItem.setExpirationDate(request.expirationDate());

        return foodItemMapper.toResponse(foodItemRepository.save(foodItem));
    }

    public void deleteFood(Long id) {
        if (foodItemRepository.existsById(id)) {
            foodItemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Food not found with id: " + id);
        }
    }

}
