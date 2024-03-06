package cgg.blogapp.bloggingapplication.mapper;

import java.util.function.Function;

import cgg.blogapp.bloggingapplication.entities.User;
import cgg.blogapp.bloggingapplication.payloads.UserRecord;

public class UserEntityToRecord  implements Function<User,UserRecord>{

    @Override
    public UserRecord apply(User user) {
       return new UserRecord(user.getId(), user.getName(),user.getEmail(), user.getPassword(),user.getAbout());
    }
    
}
