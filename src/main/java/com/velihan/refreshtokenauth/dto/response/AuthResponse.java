package com.velihan.refreshtokenauth.dto.response;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {}