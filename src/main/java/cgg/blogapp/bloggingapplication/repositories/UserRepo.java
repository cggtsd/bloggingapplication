package cgg.blogapp.bloggingapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.blogapp.bloggingapplication.entities.User;

public interface UserRepo  extends JpaRepository<User,Integer>{
    
}
