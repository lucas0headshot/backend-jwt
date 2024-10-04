package com.lucas.jwt.enterprise.exceptions;

public class TokenGenerationException extends RuntimeException {
    public TokenGenerationException(String message, Exception e) {
        super(message, e);
    }
}
