package com.student.studentdata.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    //secret key
//    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.ES512);

//    private final int expireToken = 3600;
    
}
