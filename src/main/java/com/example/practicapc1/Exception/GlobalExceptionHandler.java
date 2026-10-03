package com.example.practicapc1.Exception;

import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class})
    public ProblemDetail handleNotFound(RuntimeException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(404);
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ProblemDetail handleConflict(RuntimeException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(409);
        problemDetail.setTitle("Conflict");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handleUnauthorized(RuntimeException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(401);
        problemDetail.setTitle("Unauthorized");
        problemDetail.setDetail("Credenciales incorrectas");
        return problemDetail;
    }
}
