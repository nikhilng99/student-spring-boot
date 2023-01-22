package com.example.amigoscode.controller;

import com.example.amigoscode.dao.StudentRepository;
import com.example.amigoscode.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/student")
@RestController
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    record NewStudent(
            String name,
            String email,
            Integer age,
            Optional id
    ){

    }
//    @PostMapping
//    public void addStudent(@RequestBody Student student){
//        studentRepository.save(student);
//    }
    @PostMapping
    public void addStudent(@RequestBody NewStudent newStudent){
        Student student = new Student();
        student.setName(newStudent.name);
        student.setAge(newStudent.age);
        student.setEmail(newStudent.email);
        studentRepository.save(student);
    }
    @DeleteMapping("{customerId}")
    public void deleteStudents(@PathVariable("customerId") Integer id){
        studentRepository.deleteById(id);
    }
    @PutMapping("{customerId}")
    public void updateStudents(@PathVariable("customerId") Integer id, @RequestBody NewStudent newStudent){
        Student student = new Student();
        student.setName(newStudent.name);
        student.setAge(newStudent.age);
        student.setEmail(newStudent.email);
        studentRepository.deleteById(id);
        studentRepository.save(student);
    }

}
