package com.example.studentdto.dto;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Component
public class StudentCreateRequestDto {
    @NotBlank(message="Name should not blank ,empty or blank spaces")
    @Size(min=5,max=50,message = "Length of Name should be in between 5 to 50")
    private String name;
    @NotNull(message = "Email should not blank")
    @Email(message = "Email is not valid")
    private String email;
 //   @NotEmpty
 //   @Pattern(regexp = "^[6-9][0-9]{9}$",message = "Mobile number format is wrong")
    private Long mob;
    @NotEmpty
    private String subject;
    @NotNull
    private String Address;

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
}
