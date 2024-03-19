package cgg.blogapp.bloggingapplication.payloads;

import cgg.blogapp.bloggingapplication.validate.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRecord(
   
    int id,
    @NotEmpty
    String name,
    @Email
    String email,
    @NotEmpty
    String password,
    @NotEmpty
    String about,
    @ImageNameValid
    String imageName) {
    
}
