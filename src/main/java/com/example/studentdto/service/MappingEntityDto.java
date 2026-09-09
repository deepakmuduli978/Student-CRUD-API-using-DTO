package com.example.studentdto.service;

import com.example.studentdto.StudentdtoApplication;
import com.example.studentdto.dto.StudentCreateRequestDto;
import com.example.studentdto.dto.StudentResponseDto;
import com.example.studentdto.dto.StudentUpdateRequestDto;
import com.example.studentdto.dto.StudentUpdateResponseDto;
import com.example.studentdto.entity.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MappingEntityDto {
    private StudentCreateRequestDto dto;
    public MappingEntityDto(StudentCreateRequestDto dto,StudentResponseDto dtoresp){
        this.dto=dto;


    }
    public Student DtotoEntity(StudentCreateRequestDto dto){
        Student std=new Student();
        std.setName(dto.getName());
        std.setMob(dto.getMob());
        std.setEmail(dto.getEmail());
        std.setSubject(dto.getSubject());
        std.setAddress(dto.getAddress());
        std.setDeleted(false);
        std.setCreateDate(LocalDate.now());
        std.setUpdatedate(LocalDate.now());
        return std;
    }
    public StudentCreateRequestDto EntitytoDto(Student entity){
        dto.setAddress(entity.getAddress());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setMob(entity.getMob());
        dto.setSubject(entity.getSubject());
        return dto;
    }

    public List<StudentResponseDto> EntitytoDtoResponse(List<Student> entities){

        List<StudentResponseDto> respdtoList=new ArrayList<>();

        for(Student entity: entities) {
            StudentResponseDto dtoresp=new StudentResponseDto();
            dtoresp.setAddress(entity.getAddress());
            dtoresp.setCreateDate(entity.getCreateDate());
            dtoresp.setEmail(entity.getEmail());
            dtoresp.setMob(entity.getMob());
            dtoresp.setName(entity.getName());
            dtoresp.setSubject(entity.getSubject());
            dtoresp.setUpdatedate(entity.getUpdatedate());
            respdtoList.add(dtoresp);
        }
        return respdtoList;

    }
    public StudentResponseDto EntitytoDtoResponseById(Student entity){
        StudentResponseDto dtoresp=new StudentResponseDto();
        dtoresp.setAddress(entity.getAddress());
        dtoresp.setCreateDate(entity.getCreateDate());
        dtoresp.setEmail(entity.getEmail());
        dtoresp.setMob(entity.getMob());
        dtoresp.setName(entity.getName());
        dtoresp.setSubject(entity.getSubject());
        dtoresp.setUpdatedate(entity.getUpdatedate());
        return dtoresp;
    }
    public Student updateDtotoEntity(StudentUpdateRequestDto stddto,Student updatedto){
        updatedto.setName(stddto.getName());
        updatedto.setAddress(stddto.getAddress());
        updatedto.setMob(stddto.getMob());
        updatedto.setSubject(stddto.getSubject());
        updatedto.setUpdatedate(LocalDate.now());

        return updatedto;
    }
    public StudentUpdateResponseDto UpdateEntitytoDto(Student stdentity){
        StudentUpdateResponseDto stdupdatedto=new StudentUpdateResponseDto();
        stdupdatedto.setName(stdentity.getName());
        stdupdatedto.setEmail(stdentity.getEmail());
        stdupdatedto.setMob(stdentity.getMob());
        stdupdatedto.setAddress(stdentity.getAddress());
        stdupdatedto.setSubject(stdentity.getSubject());
        stdupdatedto.setCreateDate(stdentity.getCreateDate());
        stdupdatedto.setUpdatedate(stdentity.getUpdatedate());
        stdupdatedto.setMessage("Updated record id "+stdentity.getId()+" Successful");
        return stdupdatedto;
    }
}
