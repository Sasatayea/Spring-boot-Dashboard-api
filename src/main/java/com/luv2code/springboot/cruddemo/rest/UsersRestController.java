package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.entity.loginRequest;
import com.luv2code.springboot.cruddemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/User")
public class UsersRestController {

    private UserService userService;

    @Autowired
    public UsersRestController(UserService theuserService) {
        userService = theuserService;
    }

    // export "/users" and return a list of users
    @Operation(summary = "Get All users")
    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    // export "/user/{id}" and return the user with the given id
    @Operation(summary = "Get User by id")
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {

        Users users = userService.findById(id);

        if(users == null) {
            throw new RuntimeException("Employee not found for id: " + id);
        }

        return users;
    }
    @Operation(summary = "User Login")
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody loginRequest loginRequest){

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        ResponseEntity<?> user = userService.Login(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }

    }

//    @GetMapping("/user/email/{email}")
//    public Users getUserByEmail(@PathVariable String email) {
//        Users users = userService.findByEmail(email);
//        return users;
//    }

    // add mapping for POST "/users" create a new user
    @Operation(summary = "Add a new user")
    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody @Valid Users TheUser) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        TheUser.setUser_id(0);
        ResponseEntity<?> dbUser = userService.insert(TheUser);
        return ResponseEntity.ok( dbUser);
    }

    // add mapping for PUT "/employees" update an existing employee
    @Operation(summary = "Update an existing User")
    @PutMapping("")
    public Users updateUser(@RequestBody @Valid Users TheUser) {
        Users dbUser = userService.update(TheUser);
        return dbUser;
    }

    // add mapping for DELETE "/user/{id}" delete an user
    @Operation(summary = "Delete a user by id")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        // get the employee by id before deleting
        Users theUser = userService.findById(id);

        if(theUser == null) {
            throw new RuntimeException("Employee is not found for id: " + id);
        }

        userService.deleteById(id);
        return "Deleted User with id: " + id;
    }

}
