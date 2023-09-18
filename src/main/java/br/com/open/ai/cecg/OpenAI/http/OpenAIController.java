package br.com.open.ai.cecg.OpenAI.http;

import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksForYouRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.BestHorrorBooksRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

public interface OpenAIController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO);


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    String generateBestHorrorBooks(@RequestBody BestHorrorBooksRequestDTO requestDTO);


    @PostMapping(value = "/best-horror-books")
    @ResponseStatus(HttpStatus.OK)
    String generateBestHorrorBooksForYou(@RequestBody BestHorrorBooksForYouRequestDTO requestDTO);

}

