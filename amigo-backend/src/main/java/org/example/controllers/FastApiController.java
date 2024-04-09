package org.example.controllers;

import org.example.services.FastApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FastApiController {

    @Autowired
    private FastApiService fastApiService;

    @PostMapping("/api/send-message")
    public Mono<String> sendMessage(@RequestBody String input) {
        return fastApiService.sendMessage(input);
    }
}
