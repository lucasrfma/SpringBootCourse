package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService
{
    public List<Student> getStudents()
    {
        return List.of(
                new Student(
                        1L,
                        "Lucas",
                        28,
                        LocalDate.of(1993,4,27),
                        "Lucasrfma@gmail.com"
                )
        );
    }
}
