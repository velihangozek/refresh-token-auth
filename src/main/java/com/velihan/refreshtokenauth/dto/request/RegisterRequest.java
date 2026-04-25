package com.velihan.refreshtokenauth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String email,
        @NotBlank String password
) {}