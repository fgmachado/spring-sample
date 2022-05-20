package com.example.springsample.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.springsample.vo.ErrorVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(NOT_FOUND)
  public ResponseEntity<ErrorVO> handleNotFoundException(final NoHandlerFoundException exception,
      final WebRequest request) {
    final ErrorVO error = ErrorVO.builder()
        .status(NOT_FOUND)
        .statusCode(NOT_FOUND.value())
        .message(exception.getMessage())
        .build();

    return ResponseEntity.status(NOT_FOUND.value()).body(error);
  }

}
