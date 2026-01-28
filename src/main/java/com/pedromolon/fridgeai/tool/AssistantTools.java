package com.pedromolon.fridgeai.tool;

import com.pedromolon.fridgeai.dto.response.FoodItemResponse;
import com.pedromolon.fridgeai.service.FoodItemService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssistantTools {

    private final FoodItemService foodItemService;

    public AssistantTools(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @Tool("Gera uma receita com base nos ingredientes disponíveis no banco de dados da aplicação")
    public String generateRecipe() {
        List<FoodItemResponse> foodItems = foodItemService.getAllFoods();

        if (foodItems.isEmpty()) {
            return "Não existe ingredientes cadastrados no momento";
        }

        return String.format("Os ingredientes encontrados foram os seguintes: " + foodItems.toString());
    }

}
