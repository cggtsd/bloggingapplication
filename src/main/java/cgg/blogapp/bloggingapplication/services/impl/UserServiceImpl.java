package cgg.blogapp.bloggingapplication.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cgg.blogapp.bloggingapplication.entities.User;
import cgg.blogapp.bloggingapplication.exceptions.ResourceNotFoundException;
import cgg.blogapp.bloggingapplication.mapper.UserEntityToRecord;
import cgg.blogapp.bloggingapplication.mapper.UserRecordToEntity;
import cgg.blogapp.bloggingapplication.payloads.UserRecord;
import cgg.blogapp.bloggingapplication.repositories.UserRepo;
import cgg.blogapp.bloggingapplication.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    private UserRecordToEntity toUserEntity=new UserRecordToEntity();
    private UserEntityToRecord toUserRecord=new UserEntityToRecord();

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserRecord createUser(UserRecord userRecord) {
      var entity= toUserEntity.apply(userRecord);
      User savedUser = userRepo.save(entity);
      return toUserRecord.apply(savedUser);
    }

    @Override
    public UserRecord updateUser(UserRecord userRecord, int id) {
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        user.setName(userRecord.name());
        user.setEmail(userRecord.email());
        user.setPassword(userRecord.password());
        user.setAbout(userRecord.about());

        
        User updatedUser = userRepo.save(user);
        return toUserRecord.apply(updatedUser);
    }

    @Override
    public UserRecord getUserById(int id) {
         User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
         return toUserRecord.apply(user);
    }

    @Override
    public List<UserRecord> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(user->toUserRecord.apply(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {
       User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
       userRepo.delete(user);
    }
    
}
