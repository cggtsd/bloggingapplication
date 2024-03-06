package cgg.blogapp.bloggingapplication.services;

import java.util.List;

import cgg.blogapp.bloggingapplication.payloads.UserRecord;

public interface UserService {

    UserRecord createUser(UserRecord userRecord);

    UserRecord updateUser(UserRecord userRecord, int id);

    UserRecord getUserById(int id);

    List<UserRecord> getAllUsers();

    void deleteUser(int id);
}
