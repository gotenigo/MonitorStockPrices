package com.acme.mytrader.controller;

import java.util.List;

public class ApiError {


    private final String message;
    private final List<String> errors;

    ApiError(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }



}