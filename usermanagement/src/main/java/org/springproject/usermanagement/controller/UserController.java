package org.springproject.usermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springproject.usermanagement.model.User;
import org.springproject.usermanagement.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "htts://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/addUsers")
    public ResponseEntity<String> addUser(@RequestBody User user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
            return ResponseEntity.ok("User added successfully");
        }
        return ResponseEntity.internalServerError().body("User not found");
    }
}
