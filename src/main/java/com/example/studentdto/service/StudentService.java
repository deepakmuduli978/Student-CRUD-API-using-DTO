package com.example.studentdto.service;

import com.example.studentdto.entity.Student;
import com.example.studentdto.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student findone(Integer id){
        Optional<Student> details=repository.findById(id);
        if(details.isEmpty()){
            return null;
        }
        return details.get();
    }

    public Student updatedetails(Student student,Integer id){
        Optional<Student> isexist=repository.findById(id);
        if(isexist.isEmpty()){
            return null;
        }
        Student ref=isexist.get();
        ref.setName(student.getName());
        ref.setAddress(student.getAddress());
        ref.setEmail(student.getEmail());
        ref.setMob(student.getMob());
        ref.setSubject(student.getSubject());
        ref.setDeleted(student.isDeleted());
        return repository.save(ref);
    }

    public Student harddelete(Integer id){
        Optional<Student> isexist=repository.findById(id);
        if(isexist.isEmpty()){
            return null;
        }
        repository.deleteById(id);
        return isexist.get();
    }

    public Student softdelete(Integer id){
        Optional<Student> isexist=repository.findById(id);
        if(isexist.isEmpty())
        {
        return null;
        }
        Student ref= isexist.get();
    //    if(ref.isDeleted()==true) return null;
        ref.setDeleted(true);
        return repository.save(ref);
    }
}
