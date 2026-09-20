package com.example.studentdto.controller;

import com.example.studentdto.dto.StudentCreateRequestDto;
import com.example.studentdto.dto.StudentResponseDto;
import com.example.studentdto.dto.StudentUpdateRequestDto;
import com.example.studentdto.dto.StudentUpdateResponseDto;
import com.example.studentdto.entity.Student;
import com.example.studentdto.service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<StudentCreateRequestDto> createstudent(@Valid @RequestBody StudentCreateRequestDto studentdto){
        StudentCreateRequestDto save=service.createstd(studentdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDto>> Getall(){
        List<StudentResponseDto> getdetailsdto=service.findall();
        //Here we comment it because we now handle the exception mannually no need to handle the error or exceptioni in controller file
        //we create a separete file Global exception handler to handle all types or error and exceptions
//        if (getdetailsdto==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getdetailsdto);
//        }
        return ResponseEntity.status(HttpStatus.FOUND).body(getdetailsdto);
    }

    @GetMapping("/get")
    public ResponseEntity<StudentResponseDto> GetOne(@RequestParam Integer id){
        StudentResponseDto getdto=service.findone(id);
        if(getdto==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getdto);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(getdto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentUpdateResponseDto> update(@RequestBody StudentUpdateRequestDto student, @PathVariable Integer id){
        StudentUpdateResponseDto updatedto=service.updatedetails(student,id);
        if(updatedto==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedto);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedto);
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
//        Boolean isdeleterecord=service.softdelete(id);
//        if(isdeleterecord==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your record doesn't exist we can't perform softdelete");
//        } else if (isdeleterecord==false) {
//            return ResponseEntity.status(HttpStatus.FOUND).body("Your Record is already softdelete is true");
//        }
//        return ResponseEntity.status(HttpStatus.FOUND).body("Your record is marked as softdelete");
        //This above is used for own logic but we implement our own jpa methods so change it into bellow
        Boolean isdeletedrecord=service.softdelete(id);
        if(isdeletedrecord==false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your record doesn't exist we can't perform softdelete");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Your record is marked as soft delete");
    }

}
