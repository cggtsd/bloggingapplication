package cgg.blogapp.bloggingapplication.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.blogapp.bloggingapplication.payloads.UserRecord;
import cgg.blogapp.bloggingapplication.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Post - create user
    @PostMapping("/")
    public ResponseEntity<UserRecord> createUser( @RequestBody UserRecord userRecord){

        UserRecord userDetails = userService.createUser(userRecord);
        return new ResponseEntity<>(userDetails,HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<UserRecord>> getAllUsers(){
        List<UserRecord> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> getUserById(@PathVariable int id){
        UserRecord user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
