package cgg.blogapp.bloggingapplication.payloads;

import cgg.blogapp.bloggingapplication.validate.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserRecord(
   
    int id,
    @NotEmpty
    @Size(min=4,message="Username must be min of 4 characters !!")
    String name,
    @Email(message="Email address is not valid !!")
    String email,
    @NotEmpty
    @Size(min=3,max=10,message="Password must be min of 3 chars and max of 10 chars !!")
    String password,
    @NotEmpty
    String about,
    @ImageNameValid
    String imageName) {
    
}
