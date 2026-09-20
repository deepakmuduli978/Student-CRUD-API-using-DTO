package com.example.studentdto.exception;

import com.example.studentdto.dto.ExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> HandleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){

        ExceptionResponseDto exceptionrespdto= new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionrespdto);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> HandleDuplicateResourceException(DuplicateResourceException ex,HttpServletRequest request){
        ExceptionResponseDto responseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.FOUND.value(),
                HttpStatus.FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.FOUND).body(responseDto);
    }
}
