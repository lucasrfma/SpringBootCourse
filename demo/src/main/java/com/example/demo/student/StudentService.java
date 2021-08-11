package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    /**
     * method created by myself before seeing the solution on the following video
     * @param student
     */
//    public void addNewStudent(Student student) throws EmailAlreadyRegisteredException
//    {
//        var studentList = studentRepository.findAll();
//
//        if( studentList.stream().anyMatch((existingStudent) ->
//            existingStudent.getEmail().equals(student.getEmail())
//        ))
//        {
//            throw new EmailAlreadyRegisteredException();
//        };
//
//        studentRepository.save(student);
//    }

    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new EmailAlreadyRegisteredException();
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty())
        {
            throw new IdNotFoundException();
        }

        studentRepository.deleteById(id);
    }

//    @Transactional
//    public void updateStudent(Long id, Student updatedStudent)
//    {
//        Optional<Student> studentOptional = studentRepository.findById(id);
//
//        if(studentOptional.isEmpty())
//        {
//            throw new IdNotFoundException();
//        }
//
//        Student student = studentOptional.get();
//
//        student.setEmail(updatedStudent.getEmail());
//        student.setName(updatedStudent.getName());
//    }

    @Transactional
    public void updateStudent(Long id, String name, String email)
    {
        Student student = studentRepository.findById(id)
                .orElseThrow(IdNotFoundException::new);

        if(email != null &&
            email.length() > 0 &&
            !student.getEmail().equals(email))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new EmailAlreadyRegisteredException();
            }
            student.setEmail(email);
        }

        if(name != null &&
                name.length() > 0 &&
                !student.getName().equals(name))
        {
            student.setName(name);
        }
    }
}


