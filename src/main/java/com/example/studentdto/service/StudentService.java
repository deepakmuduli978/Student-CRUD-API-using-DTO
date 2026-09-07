package com.example.studentdto.service;

import com.example.studentdto.entity.Student;
import com.example.studentdto.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;
    //constructor injection
    public StudentService(StudentRepository repository){
        this.repository=repository;
    }

    public Student createstd(Student stdreq){
        Student stdresp=repository.save(stdreq);
        return stdresp;
    }
    public List<Student> findall(){
        List<Student> getdetails=repository.findAll();
        return getdetails;
    }
}
