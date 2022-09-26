package it.spindox.tutor.spindoxspring.controller;

import java.net.http.HttpHeaders;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mongodb.internal.bulk.WriteRequest;

import antlr.collections.List;
import it.spindox.tutor.spindoxspring.exception.ErrorMessage;
import it.spindox.tutor.spindoxspring.exception.ResourceNotFoundException;
import lombok.Data;

@Data
@RestControllerAdvice
public class AdvisorController {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.NOT_FOUND.value(),
          new Date(),
          ex.getMessage(),
          request.getDescription(false));
      
      return message;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          new Date(),
          ex.getMessage(),
          request.getDescription(false));
      
      return message;
    }


}