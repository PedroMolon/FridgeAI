package com.pedromolon.fridgeai.service;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAiService {

    @SystemMessage("""
            Você é um chef de cozinha. Quando o usuário pedir uma receita,
            utilize a ferramenta disponível para verificar quais ingredientes
            existem no banco de dados e, então, elabore uma receita apenas
            com esses itens.
            """)
    Result<String> handleRecipe(@UserMessage String userMessage);

}
