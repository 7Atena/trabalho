package br.com.open.ai.cecg.OpenAI.service;

import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksForYouRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

public interface CallOpenAiService {
    String generateScienceFiction(ScienceFictionRequestDTO requestDTO);
    String generateBestHorrorBooks(BestHorrorBooksRequestDTO requestDTO);
    String generateBestHorrorBooksForYou(BestHorrorBooksForYouRequestDTO requestDTO);
}
