package com.example.studentdto.service;

import com.example.studentdto.dto.StudentCreateRequestDto;
import com.example.studentdto.dto.StudentResponseDto;
import com.example.studentdto.dto.StudentUpdateRequestDto;
import com.example.studentdto.dto.StudentUpdateResponseDto;
import com.example.studentdto.entity.Student;
import com.example.studentdto.repository.StudentRepository;
import org.springframework.stereotype.Service;

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
        Student stdresp=repository.save(entity);
        return map.EntitytoDto(stdresp);
    }
    public List<StudentResponseDto> findall(){
        List<Student> getentity=repository.findByAndIsDeletedIsFalse();
        List<StudentResponseDto> respdto=map.EntitytoDtoResponse(getentity);
        return respdto;
    }

    public StudentResponseDto findone(Integer id){
        Optional<Student> stdentity=repository.findByIdAndIsDeletedIsFalse(id);
        if(stdentity.isEmpty()){
            return null;
        }
        StudentResponseDto stddto=map.EntitytoDtoResponseById(stdentity.get());

        return stddto;
    }

    public StudentUpdateResponseDto updatedetails(StudentUpdateRequestDto student, Integer id){
        Optional<Student> isexist=repository.findByIdAndIsDeletedIsFalse(id);
        if(isexist.isEmpty()){
            return null;
        }
        Student updateEntity=map.updateDtotoEntity(student,isexist.get());
        repository.save(updateEntity);
        StudentUpdateResponseDto updatedDtoresp=map.UpdateEntitytoDto(updateEntity);
        return updatedDtoresp;
    }

    public Student harddelete(Integer id){
        Optional<Student> isexist=repository.findById(id);
        if(isexist.isEmpty()){
            return null;
        }
        repository.deleteById(id);
        return isexist.get();
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
        Optional<Student> isexist=repository.findByIdAndIsDeletedIsFalse(id);
        if(isexist.isEmpty()){
            return false;
        }
        Student ref=isexist.get();
        ref.setDeleted(true);
        repository.save(ref);
        return true;
    }
}
