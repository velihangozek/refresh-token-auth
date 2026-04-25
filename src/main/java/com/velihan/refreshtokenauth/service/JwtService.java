package com.velihan.refreshtokenauth.service;

import com.velihan.refreshtokenauth.config.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final JwtProperties jwtProperties;

}