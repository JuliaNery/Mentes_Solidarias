package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class MeetController {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    private static final String CLIENT_ID = "449743394788-ss8qmcctin675k5j55l2muvnmvr78eaj.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "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";
    private static final String REDIRECT_URI = "http://localhost:8080/api/callback";
    private static final String AUTHORIZATION_ENDPOINT = "https://accounts.google.com/o/oauth2/auth";
    private static final String TOKEN_ENDPOINT = "https://oauth2.googleapis.com/token";
    private static final String SCOPE = "https://www.googleapis.com/auth/calendar.events";

    @Autowired
    public MeetController(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/video-link")
    public ResponseEntity<String> generateVideoLink() {
        try {
            String authorizationUrl = String.format("%s?client_id=%s&redirect_uri=%s&response_type=code&scope=%s",
                    AUTHORIZATION_ENDPOINT, CLIENT_ID, REDIRECT_URI, SCOPE);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header(HttpHeaders.LOCATION, authorizationUrl)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/callback")
    public ResponseEntity<String> handleCallback(String code) {
        try {
            HttpHeaders tokenRequestHeaders = new HttpHeaders();
            tokenRequestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<>();
            tokenRequestBody.add("code", code);
            tokenRequestBody.add("client_id", CLIENT_ID);
            tokenRequestBody.add("client_secret", CLIENT_SECRET);
            tokenRequestBody.add("redirect_uri", REDIRECT_URI);
            tokenRequestBody.add("grant_type", "authorization_code");

            HttpEntity<MultiValueMap<String, String>> tokenRequestEntity = new HttpEntity<>(tokenRequestBody, tokenRequestHeaders);

            ResponseEntity<CustomTokenResponse> tokenResponseEntity = restTemplate.exchange(
                    TOKEN_ENDPOINT, HttpMethod.POST, tokenRequestEntity, CustomTokenResponse.class);

            if (tokenResponseEntity.getStatusCode().is2xxSuccessful()) {
                CustomTokenResponse tokenResponse = tokenResponseEntity.getBody();
                String accessToken = tokenResponse.getAccessToken();

                Map<String, Object> requestBody = new HashMap<>();
                requestBody.put("conferenceDataVersion", 1);

                Map<String, Object> conferenceData = new HashMap<>();
                conferenceData.put("createRequest", new HashMap<>());

                requestBody.put("conferenceData", conferenceData);
                requestBody.put("summary", "Nova Sala do Google Meet");

                LocalDateTime startDateTime = LocalDateTime.now().plusHours(1);
                LocalDateTime endDateTime = startDateTime.plusHours(1);
                Map<String, Object> start = new HashMap<>();
                start.put("dateTime", startDateTime.toString());
                start.put("timeZone", "America/Sao_Paulo");
                requestBody.put("start", start);
                Map<String, Object> end = new HashMap<>();
                end.put("dateTime", endDateTime.toString());
                end.put("timeZone", "America/Sao_Paulo");
                requestBody.put("end", end);

                String requestBodyJson = objectMapper.writeValueAsString(requestBody);

                String apiUrl = "https://www.googleapis.com/calendar/v3/calendars/primary/events";
                HttpHeaders createEventHeaders = new HttpHeaders();
                createEventHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                createEventHeaders.setContentType(MediaType.APPLICATION_JSON);
                createEventHeaders.setBearerAuth(accessToken);

                HttpEntity<String> createEventEntity = new HttpEntity<>(requestBodyJson, createEventHeaders);

                ResponseEntity<String> createEventResponseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, createEventEntity, String.class);
                if (createEventResponseEntity.getStatusCode().is2xxSuccessful()) {
                    Map<String, Object> responseMap = objectMapper.readValue(createEventResponseEntity.getBody(), Map.class);
                    if (responseMap != null && responseMap.containsKey("conferenceData")) {
                        Map<String, Object> conferenceDataResponse = (Map<String, Object>) responseMap.get("conferenceData");
                        if (conferenceDataResponse != null && conferenceDataResponse.containsKey("createRequest")) {
                            Map<String, Object> createRequest = (Map<String, Object>) conferenceDataResponse.get("createRequest");
                            String meetingLink = (String) createRequest.get("conferenceSolution");
                            if (meetingLink != null && !meetingLink.isEmpty()) {
                                return ResponseEntity.status(HttpStatus.FOUND)
                                        .header(HttpHeaders.LOCATION, meetingLink)
                                        .build();
                            } else {
                                // Lógica para lidar com caso o link da chamada não seja obtido
                            }
                        } else {
                            // Lógica para lidar com resposta inesperada
                        }
                    } else {
                        // Lógica para lidar com resposta inesperada
                    }
                } else {
                    // Caso a criação do evento falhe
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            } else {
                // Se a obtenção do token falhar, trate o erro aqui
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (JsonProcessingException e) {
            // Em caso de erro ao processar o JSON
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // Caso ocorra algum erro inesperado
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
