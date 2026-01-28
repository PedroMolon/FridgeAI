package com.pedromolon.fridgeai.dto.response;

import com.pedromolon.fridgeai.model.enums.FoodCategory;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FoodItemResponse(
        Long id,
        String name,
        Integer quantity,
        FoodCategory category,
        LocalDate expirationDate
) {
}
