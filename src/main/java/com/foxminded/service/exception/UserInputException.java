package com.foxminded.service.exception;

public class UserInputException extends Exception {

    public UserInputException() {
    }

    public UserInputException(String message) {
        super(message);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
