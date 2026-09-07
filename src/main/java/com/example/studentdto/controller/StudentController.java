package com.example.studentdto.controller;

import com.example.studentdto.entity.Student;
import com.example.studentdto.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/create")
    public Student createstudent(@RequestBody Student student){
        Student save=service.createstd(student);
        return save;
    }

    public List<Student> Getall(){
        List<Student> getdetails=service.findall();
        return getdetails;
    }


}
