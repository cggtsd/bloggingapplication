package cgg.blogapp.bloggingapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.blogapp.bloggingapplication.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
    
}
