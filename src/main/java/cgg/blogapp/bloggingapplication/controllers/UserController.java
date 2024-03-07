package cgg.blogapp.bloggingapplication.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.blogapp.bloggingapplication.payloads.ApiResponse;
import cgg.blogapp.bloggingapplication.payloads.UserRecord;
import cgg.blogapp.bloggingapplication.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Post - create user
    @PostMapping("/")
    public ResponseEntity<UserRecord> createUser(@Valid @RequestBody UserRecord userRecord){

        UserRecord userDetails = userService.createUser(userRecord);
        return new ResponseEntity<>(userDetails,HttpStatus.CREATED);

    }

    //Get - All Users
    @GetMapping("/")
    public ResponseEntity<List<UserRecord>> getAllUsers(){
        List<UserRecord> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    //Get - Single User
    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> getUserById(@PathVariable int id){
        UserRecord user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //Put - Update User

    @PutMapping("/{id}")
    public ResponseEntity<UserRecord> updateUser(@Valid @RequestBody UserRecord userRecord,@PathVariable int id){
           UserRecord updateUser = this.userService.updateUser(userRecord, id);
           return ResponseEntity.ok(updateUser);
    }

    //Delete - Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
          this.userService.deleteUser(id);
          return new ResponseEntity<>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }
}
