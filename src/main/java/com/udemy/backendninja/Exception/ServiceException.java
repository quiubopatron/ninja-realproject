package com.udemy.backendninja.Exception;

public class ServiceException extends RuntimeException{

    public ServiceException (String message) {
        super(message);
    }
}
