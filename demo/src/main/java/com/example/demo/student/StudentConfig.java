package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig
{
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student lucas = new Student(
                    "Lucas",
                    LocalDate.of(1992,1,1),
                    "lucas@gmail.com"
            );
            Student maria = new Student(
                    "Maria",
                    LocalDate.of(1991,1,1),
                    "marial@gmail.com"
            );
            repository.saveAll(List.of(lucas,maria));

        };
    }
}
