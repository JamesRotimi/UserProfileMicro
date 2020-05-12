package com.example.demo.controller.exception;

public class ReplicatedEmailException extends RuntimeException {

    public ReplicatedEmailException() {
        super("Email address already taken");
    }
}
