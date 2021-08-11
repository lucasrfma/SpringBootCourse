package com.example.demo.student;

public class IdNotFoundException extends RuntimeException
{
    public IdNotFoundException() {
        super("Não foi encontrado uma entrada com essa ID.");
    }
}
