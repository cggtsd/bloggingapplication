package cgg.blogapp.bloggingapplication.exceptions;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public record GlobalExceptionHandler() {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleResourceNotFoundException(ResourceNotFoundException ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Resourse Not Found");
        pd.setDetail(ex.getMessage());
        pd.setType(URI.create("http://localhost:8080/errors"));
        pd.setProperty("timestamp",LocalDateTime.now());
         return new ResponseEntity<>(pd,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String ,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
            Map<String ,Object> resp= new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach(error->{
               String fieldName= ((FieldError)error).getField();
               String message= error.getDefaultMessage();
               resp.put(fieldName, message);
            });
     
           
            return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);

    }
}
