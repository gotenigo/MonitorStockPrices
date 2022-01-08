package com.acme.mytrader.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Object not found")
public class objectNotFoundException extends RuntimeException {

    public objectNotFoundException() {
    }

    public objectNotFoundException(String message) {
        super(message);
    }


}
