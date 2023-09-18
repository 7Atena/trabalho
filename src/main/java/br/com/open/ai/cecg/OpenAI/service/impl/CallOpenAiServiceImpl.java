package br.com.open.ai.cecg.OpenAI.service.impl;

import java.util.List;

import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksForYouRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksRequestDTO;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;

import org.springframework.stereotype.Service;

import br.com.open.ai.cecg.OpenAI.component.ChatStreamComponent;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;

@Service
public record CallOpenAiServiceImpl(ChatStreamComponent streamComponent) implements CallOpenAiService {

    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estória de ficção científica de acordo com o " +
                    "seguinte cenário: %s";

    public static final String BEST_HORROR_BOOKS_PROMPT_MESSAGE =
            "Recomende os melhores livros de terror " +
                    " %s";

    public static final String BEST_HORROR_BOOKS_FOR_YOU_PROMPT_MESSAGE =
            "Recomendacoes dos melhores livros de terror " +
                    " %s";

    @Override
    public String generateScienceFiction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }

    @Override
    public String generateBestHorrorBooks(BestHorrorBooksRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(BEST_HORROR_BOOKS_PROMPT_MESSAGE, requestDTO.genre()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }

    @Override
    public String generateBestHorrorBooksForYou(BestHorrorBooksForYouRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(BEST_HORROR_BOOKS_FOR_YOU_PROMPT_MESSAGE))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}
