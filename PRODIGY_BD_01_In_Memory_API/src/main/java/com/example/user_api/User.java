package com.example.user_api;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {
    private UUID id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 0, message = "Age cannot be empty")
    @Max(value = 150, message = "Age must be realistic")
    private int age;

    //Constructor
    public User() {}

    public User(UUID id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    //Getters and Setters
    public UUID getId() {return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() {return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() {return email; }
    public void setEmail(String email) { this.email = email; }
    public int getAge() {return age; }
    public void setAge(int age) { this.age = age; }
}