package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class FastApiService {

    private final WebClient webClient;

    @Autowired
    public FastApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://bot:5001").build();
    }

    public Mono<String> sendMessage(String input) {
        return this.webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/send_message/")
                        .queryParam("input_string", input)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        Mono.error(new RuntimeException("Client Error")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        Mono.error(new RuntimeException("Server Error")))
                .bodyToMono(String.class);
    }
}
