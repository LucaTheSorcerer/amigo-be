package org.example.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDtoExtended {
    private String accessToken;
    private String username;

    public JwtDtoExtended(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }

}
