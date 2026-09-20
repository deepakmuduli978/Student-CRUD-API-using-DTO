package com.example.studentdto.service;

import com.example.studentdto.dto.StudentCreateRequestDto;
import com.example.studentdto.dto.StudentResponseDto;
import com.example.studentdto.dto.StudentUpdateRequestDto;
import com.example.studentdto.dto.StudentUpdateResponseDto;
import com.example.studentdto.entity.Student;
import com.example.studentdto.exception.DuplicateResourceException;
import com.example.studentdto.exception.ResourceNotFoundException;
import com.example.studentdto.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.nio.ReadOnlyBufferException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repository;
    private MappingEntityDto map;
    //constructor injection
    public StudentService(StudentRepository repository,MappingEntityDto map){
        this.repository=repository;
        this.map=map;
    }


    public StudentCreateRequestDto createstd(StudentCreateRequestDto studentdto){
        Student entity=map.DtotoEntity(studentdto);
        if(existmail(entity)){
            throw new DuplicateResourceException("Please enter different mail. Email:"+
                    entity.getEmail()+" already exist");
        }
        Student stdresp=repository.save(entity);
        return map.EntitytoDto(stdresp);
    }
    public List<StudentResponseDto> findall(){
        List<Student> getentity=repository.findByAndIsDeletedIsFalse();
        if(getentity.isEmpty())
            throw new ResourceNotFoundException("No students details are available");
        List<StudentResponseDto> respdto=map.EntitytoDtoResponse(getentity);
        return respdto;
    }

    public StudentResponseDto findone(Integer id){
        Student stdentity=repository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()->new ResourceNotFoundException("Student with id:"+id+" not found"));
//        if(stdentity.isEmpty()){
//            return null;
//        }
        StudentResponseDto stddto=map.EntitytoDtoResponseById(stdentity);

        return stddto;
    }

    public StudentUpdateResponseDto updatedetails(StudentUpdateRequestDto student, Integer id){
        Student isexist=repository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()->new ResourceNotFoundException("Student with id:"+id+" not found .Can't perform update"));
//        if(isexist.isEmpty()){
//            return null;
//        }
        Student updateEntity=map.updateDtotoEntity(student,isexist);
        repository.save(updateEntity);
        StudentUpdateResponseDto updatedDtoresp=map.UpdateEntitytoDto(updateEntity);
        return updatedDtoresp;
    }

    public Student harddelete(Integer id){
        Student isexist=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student with id:"+id+" not found .We can't perfom hard delete"));
//        if(isexist.isEmpty()){
//            return null;
//        }
        repository.deleteById(id);
        return isexist;//here we show all the essential things to client .You must be perform dto mapping then show the appropriate result
    }

    public Boolean softdelete(Integer id){
//        Optional<Student> isexist=repository.findById(id);
//        if(isexist.isEmpty())
//        {
//        return null;
//        }
//        Student ref= isexist.get();
//      if(ref.isDeleted()==true) return false;
//        ref.setDeleted(true);
//        repository.save(ref);
//        return true;
        //instead of this we can use userdefined jpa methods to perform softdelete
 //       Optional<Student> isexist=repository.findByIdAndIsDeletedIsFalse(id);
        Student isexist=repository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()->new ResourceNotFoundException("Student with id:"+id+" not found.We can't perform soft delete"));
//        if(isexist.isEmpty()){
//            return false;
//        }
//        Student ref=isexist.get();
        Student ref=isexist;
        ref.setDeleted(true);
        repository.save(ref);
        return true;
    }
    public boolean existmail(Student student){
        return repository.existsByEmail(student.getEmail());
    }
}
