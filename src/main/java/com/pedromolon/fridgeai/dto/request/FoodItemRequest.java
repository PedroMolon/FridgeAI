package com.pedromolon.fridgeai.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedromolon.fridgeai.model.enums.FoodCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record FoodItemRequest(
        @NotEmpty(message = "Name cannot be empty")
        String name,

        @NotNull(message = "Quantity cannot be null")
        @Positive(message = "Quantity must be positive")
        Integer quantity,

        @NotNull(message = "Category cannot be null")
        FoodCategory category,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate expirationDate
) {
}
