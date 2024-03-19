package cgg.blogapp.bloggingapplication.entities;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserListener {
    
 @PostPersist
    public void savedCallback(Object obj){
          log.info("called before saving");
    }
}
