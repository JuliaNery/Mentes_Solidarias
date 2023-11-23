package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/api")
public class MeetController {

    @Value("${meet.api.url}")
    private String meetApiUrl;

    @GetMapping("/video-link")
    public String generateVideoLink() {
        // Construa a URL da API do Google Meet para criar uma reunião
        String apiUrl = meetApiUrl + "/v1/create-meeting"; // Substitua com a URL correta da API

        // Faça uma solicitação HTTP POST para a API do Google Meet para criar a reunião
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(apiUrl, null, String.class);

        // Verifique se a resposta não é nula antes de tentar extrair o link de videochamada
        if (response != null && !response.isEmpty()) {
            String videoLink = extractVideoLink(response);
            return videoLink != null ? videoLink : "Link de videochamada não encontrado";
        }

        return "Falha ao obter resposta da API do Google Meet";
    }

    private String extractVideoLink(String response) {
        // A resposta da API do Google Meet é um JSON, e você pode usar uma biblioteca JSON para analisá-lo.
        // Aqui está um exemplo usando a biblioteca Jackson:

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Analise a resposta JSON em um objeto MeetingResponse (você precisará criar essa classe)
            MeetingResponse meetingResponse = objectMapper.readValue(response, MeetingResponse.class);

            // Extraia o link de videochamada do objeto MeetingResponse
            return meetingResponse.getVideoLink();
        } catch (JsonProcessingException e) {
            // Lida com erros de análise JSON
            return null; // Retorna nulo se houver erro na análise do JSON
        }
    }
}
