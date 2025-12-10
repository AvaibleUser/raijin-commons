package edu.raijin.commons.infrastructure.config;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.raijin.commons.util.exception.BadRequestException;
import edu.raijin.commons.util.exception.FailedAuthenticateException;
import edu.raijin.commons.util.exception.RequestConflictException;
import edu.raijin.commons.util.exception.TimedOutException;
import edu.raijin.commons.util.exception.ValueNotFoundException;

@ControllerAdvice
public class ExceptionAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionInfo> handleBadRequest(BadRequestException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, BAD_REQUEST);
    }

    @ExceptionHandler(FailedAuthenticateException.class)
    public ResponseEntity<ExceptionInfo> handleFailedAuthenticate(FailedAuthenticateException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, UNAUTHORIZED);
    }

    @ExceptionHandler(RequestConflictException.class)
    public ResponseEntity<ExceptionInfo> handleRequestConflict(RequestConflictException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, CONFLICT);
    }

    @ExceptionHandler(ValueNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleValueNotFound(ValueNotFoundException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, NOT_FOUND);
    }

    @ExceptionHandler(TimedOutException.class)
    public ResponseEntity<ExceptionInfo> handleTimeout(TimedOutException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, REQUEST_TIMEOUT);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionInfo> handleCredentialsException(BadCredentialsException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, UNAUTHORIZED);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ExceptionInfo> handleInsufficientAuthenticationException(
            InsufficientAuthenticationException ex, WebRequest request) {
        ExceptionInfo info = new ExceptionInfo(ex.getMessage(), Instant.now());
        return new ResponseEntity<>(info, UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(toList());

        String errorsConcatenated = errors.stream().collect(joining(", "));
        ExceptionExtendedInfo info = new ExceptionExtendedInfo(errorsConcatenated, Instant.now(), errors);

        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}

record ExceptionInfo(String message, Instant timestamp) {
}

record ExceptionExtendedInfo(String message, Instant timestamp, List<String> errors) {
}
