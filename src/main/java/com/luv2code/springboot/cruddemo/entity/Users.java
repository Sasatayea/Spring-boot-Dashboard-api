package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int  userId ;

    @Column(name = "first_name")
    @NotBlank(message = "The first name should not be null")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @Email(message = "should be seam like real Email like @example.com")
    private  String email;

    @Column(name = "password")
//    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{8,20}")
    private  String password;

    @Column(name = "user_role")
    @NotBlank(message = "The Role must be added")
    private String userRole;

    @Column(name = "active")
    private byte  active;

    // Getter and setter

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public byte  getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}



/*
^: indicates the string’s beginning
(?=.*[a-z]): makes sure that there is at least one small letter
(?=.*[A-Z]): needs at least one capital letter
(?=.*\\d): requires at least one digit
(?=.*[@#$%^&+=]): provides a guarantee of at least one special symbol
.{8,20}: imposes the minimum length of 8 characters and the maximum length of 20 characters
$: terminates the string

 */