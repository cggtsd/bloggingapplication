package cgg.blogapp.bloggingapplication.mapper;

import java.util.function.Function;

import cgg.blogapp.bloggingapplication.entities.User;
import cgg.blogapp.bloggingapplication.payloads.UserRecord;

public class UserRecordToEntity implements Function<UserRecord,User>{

    @Override
    public User apply(UserRecord userRecord) {
        return new User(userRecord.id(),userRecord.name(),userRecord.email(),userRecord.password(),userRecord.about(), userRecord.imageName());
    }
    
}
