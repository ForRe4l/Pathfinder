package com.example.Pathfinder.service.DTO;

import jakarta.validation.constraints.*;

public class UserRegisterDTO {

    @NotNull
    @NotEmpty
    private String username;

    @Size(min = 5)
    @NotEmpty
    private String fullName;

    @Email
    private String email;

    @Min(5)
    @Max(90)
    private Integer age;

    @Min(5)
    private String password;

    private String confirmPassword;

    public UserRegisterDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return fullName;
    }

    public void setFull_name(String full_name) {
        this.fullName = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
