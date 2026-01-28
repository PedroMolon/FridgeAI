package com.pedromolon.fridgeai.config;

import com.pedromolon.fridgeai.service.AssistantAiService;
import com.pedromolon.fridgeai.tool.AssistantTools;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig {

    @Value( "${gemini.api-key}")
    private String geminiApiKey;

    @Value( "${gemini.model}")
    private String geminiModel;

    @Bean
    public GoogleAiGeminiChatModel googleAiGeminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                .build();
    }

    @Bean
    public AssistantAiService assistant(GoogleAiGeminiChatModel model, AssistantTools tools) {
        return AiServices.builder(AssistantAiService.class)
                .chatModel(model)
                .tools(tools)
                .build();
    }

}
