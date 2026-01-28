package com.pedromolon.fridgeai.controller;

import com.pedromolon.fridgeai.service.AssistantAiService;
import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistant")
public class AssistantController {

    private final AssistantAiService assistantAiService;

    public AssistantController(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping
    public String askAssistant(@RequestBody String message) {
        Result<String> result = assistantAiService.handleRecipe(message);
        return result.content();
    }

}
