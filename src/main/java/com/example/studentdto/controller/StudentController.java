package com.example.studentdto.controller;

import com.example.studentdto.entity.Student;
import com.example.studentdto.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> createstudent(@RequestBody Student student){
        student.setDeleted(false);
        Student save=service.createstd(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> Getall(){
        List<Student> getdetails=service.findall();
        if (getdetails==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getdetails);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(getdetails);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> GetOne(@RequestParam Integer id){
        Student getOnedetails=service.findone(id);
        if(getOnedetails==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getOnedetails);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(getOnedetails);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id){
        Student update=service.updatedetails(student,id);
        if(update==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(update);
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Delete(@PathVariable Integer id){
        Student deleterecord=service.harddelete(id);
        if(deleterecord==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your record doesn't exist");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Your record deleted permanently");
    }

    @DeleteMapping("/isdelete")
    public ResponseEntity<String> isDelete(@RequestParam Integer id){
        Boolean isdeleterecord=service.softdelete(id);
        if(isdeleterecord==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your record doesn't exist we can't perform softdelete");
        } else if (isdeleterecord==false) {
            return ResponseEntity.status(HttpStatus.FOUND).body("Your Record is already softdelete is true");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Your record is marked as softdelete");
    }

}
