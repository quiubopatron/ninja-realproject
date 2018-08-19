package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

    public static final String ERROR_500 = "/error/500";

    @ExceptionHandler(Exception.class)
    public String showInternalMessageError() {
        return ERROR_500;


    }
}
