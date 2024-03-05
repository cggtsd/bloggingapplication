package cgg.blogapp.bloggingapplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user1")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int id;
    @Column(name="user_name",length = 100)
    private String name;
    @Column(name="user_email",nullable = false)
    private String email;
    @Column(name="user_password")
    private String password;
    @Column(name="user_about")
    private String about;
    
}
