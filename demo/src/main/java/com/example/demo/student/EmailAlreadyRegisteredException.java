package com.example.demo.student;

public class EmailAlreadyRegisteredException extends RuntimeException {
    public EmailAlreadyRegisteredException()
    {
        super("Já existe uma conta com esse e-mail.");
    }
}
