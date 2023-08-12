package vn.plantpal.mobile_backend.exceptions;

import lombok.Getter;

import java.util.Map;

public class CartNotExistsProductException extends RuntimeException{
    @Getter
    private Map<String, Map<String, String>> errors;
    public CartNotExistsProductException(String message, Map<String, Map<String, String>> errors) {
        super(message);
        this.errors = errors;
    }
}
