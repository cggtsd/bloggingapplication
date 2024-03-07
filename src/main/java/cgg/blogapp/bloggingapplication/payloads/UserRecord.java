package cgg.blogapp.bloggingapplication.payloads;

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
    String about) {
    
}
