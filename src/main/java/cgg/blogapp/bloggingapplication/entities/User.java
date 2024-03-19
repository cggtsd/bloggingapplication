package cgg.blogapp.bloggingapplication.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(UserListener.class)
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int id;
    @Column(name="user_name",length = 100)
    private String name;
    @Column(name="user_email",nullable = false,unique = true)
    private String email;
    @Column(name="user_password")
    private String password;
    @Column(name="user_about")
    private String about;
    
    @Column(name="profile_pic_name")
    private String imageName;
    
}
