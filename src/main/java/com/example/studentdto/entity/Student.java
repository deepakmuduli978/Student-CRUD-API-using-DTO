package com.example.studentdto.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name="StudentDto")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private Long mob;
    private String subject;
    private String Address;
    private boolean isDeleted;
    private LocalDate CreateDate;
    private LocalDate Updatedate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMob() {
        return mob;
    }

    public void setMob(Long mob) {
        this.mob = mob;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(LocalDate CreateDate) {
       this.CreateDate = CreateDate;
    }

    public LocalDate getUpdatedate() {
        return Updatedate;
    }

    public void setUpdatedate(LocalDate Updatedate) {
        this.Updatedate = Updatedate;
    }
}
