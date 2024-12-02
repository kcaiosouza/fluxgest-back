package com.unifacisa.fluxgest.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/ia")
public class IAController {

    @Value("${openai.api.key}")
    private String apiKey;

    @PostMapping("/send")
    public ResponseEntity<String> enviarMensagem(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", new Object[] {
                Map.of("role", "user", "content", prompt)
        });

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
