package vn.plantpal.mobile_backend.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import vn.plantpal.mobile_backend.dtos.ErrorDetails;

import java.util.*;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDetails> handlerDWBException(AppException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> handlerBadRequestException(BadRequestException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handlerInternalException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ErrorDetails> handlerDuplicateRecordException(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handlerAccessDeniedException(AccessDeniedException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerUserNotFoundException(UserNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();

        for(var error : ex.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) error;
            String key = fieldError.getField();
            String message = error.getDefaultMessage();
            // Check if key exist then add message to key else add new key to object
            if(errors.containsKey(key)){
                errors.get(key).add(message);
            }else{
                List<String> list = new ArrayList<>();
                list.add(message);
                errors.put(key, list);
            }
        }

        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Invalid data", errors, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


}
