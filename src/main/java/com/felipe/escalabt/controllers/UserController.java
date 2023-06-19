package com.felipe.escalabt.controllers;

import com.felipe.escalabt.persistence.entities.Telephone;
import com.felipe.escalabt.persistence.entities.User;
import com.felipe.escalabt.persistence.repositories.IUserRepository;
import com.felipe.escalabt.services.IUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private IUserService service;

//    public ResponseEntity<User> getUser(){}
    @GetMapping
    public List<User> getUser(){
        return service.getUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String email){
        service.deleteUser(email);
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email,@RequestBody User user){
        return service.updateUser(email, user);
    }

}
