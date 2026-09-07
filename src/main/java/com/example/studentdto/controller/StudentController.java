package com.example.studentdto.controller;

import com.example.studentdto.entity.Student;
import com.example.studentdto.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    @GetMapping("/getAll")
    public List<Student> Getall(){
        List<Student> getdetails=service.findall();
        return getdetails;
    }

    @GetMapping("/get")
    public Student GetOne(@RequestParam Integer id){
        Student getOnedetails=service.findone(id);
        return getOnedetails;
    }

    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student,@PathVariable Integer id){
        Student update=service.updatedetails(student,id);
        return update;
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable Integer id){
        Student deleterecord=service.harddelete(id);
        return "Your Record Deleted Permanently";
    }

    @DeleteMapping("/isdelete")
    public String isDelete(@RequestParam Integer id){
        Student isdeleterecord=service.softdelete(id);

        return "Your record is marked as deleted";
    }

}
