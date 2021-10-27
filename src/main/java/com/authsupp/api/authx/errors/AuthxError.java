package com.authsupp.api.authx.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AuthxError extends ResponseStatusException {
    public AuthxError(HttpStatus status, String message) {
        super(status);
    }
}
