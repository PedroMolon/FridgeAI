package com.pedromolon.fridgeai.mapper;

import com.pedromolon.fridgeai.dto.request.FoodItemRequest;
import com.pedromolon.fridgeai.dto.response.FoodItemResponse;
import com.pedromolon.fridgeai.model.FoodItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItem toEntity(FoodItemRequest request);

    FoodItemResponse toResponse(FoodItem entity);

}
