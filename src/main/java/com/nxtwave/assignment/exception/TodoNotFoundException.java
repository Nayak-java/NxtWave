package com.nxtwave.assignment.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String message, int id) {
        super("for " + id + " todo not found ");


    }
}
