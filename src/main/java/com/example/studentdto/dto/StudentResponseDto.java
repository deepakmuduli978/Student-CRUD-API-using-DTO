package com.example.studentdto.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentResponseDto {
    private String name;
    private String email;
    private Long mob;
    private String subject;
    private String Address;
    private LocalDate CreateDate;
    private LocalDate Updatedate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMob() {
        return mob;
    }

    public void setMob(Long mob) {
        this.mob = mob;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public LocalDate getUpdatedate() {
        return Updatedate;
    }

    public void setUpdatedate(LocalDate updatedate) {
        Updatedate = updatedate;
    }

    public LocalDate getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(LocalDate createDate) {
        CreateDate = createDate;
    }
}
