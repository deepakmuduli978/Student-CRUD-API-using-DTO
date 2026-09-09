package com.example.studentdto.dto;

import java.time.LocalDate;

public class StudentUpdateRequestDto {
    private String name;
    private Long mob;
    private String subject;
    private String Address;
    private LocalDate Updatedate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getMob() {
        return mob;
    }

    public void setMob(Long mob) {
        this.mob = mob;
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
}
