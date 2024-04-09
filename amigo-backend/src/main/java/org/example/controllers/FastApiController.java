package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dtos.InputString;
import org.example.services.FastApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Bot Communication", description = "Endpoints for interacting with the AI bot")
public class FastApiController {

    @Autowired
    private FastApiService fastApiService;

    @PostMapping("/api/send-message")
    @Operation(summary = "Send message to AI bot", description = "Send a message to the AI bot and receive a response.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Message sent successfully",
                            content = @Content(schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request data",
                            content = @Content),
                    @ApiResponse(responseCode = "500", description = "Server error",
                            content = @Content)
            })
    public Mono<String> sendMessage(@RequestBody InputString input) {
        return fastApiService.sendMessage(input.getInput_string());
    }

}
