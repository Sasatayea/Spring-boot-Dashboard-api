package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int theId);

    ResponseEntity<?> insert(Users theUser);

    Users update(Users theUser);

    void deleteById(int theId);

    Users findByEmail(String email);

    ResponseEntity<?> Login(String email, String password);

}
