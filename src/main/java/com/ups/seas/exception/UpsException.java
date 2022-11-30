package com.ups.seas.exception;

import com.ups.seas.utility.ApiResponseErrorDto;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class UpsException extends RuntimeException {

    private static final long serialVersionID = 1L;

    private HttpStatus httpStatus;
    private String message;
    private List<ApiResponseErrorDto> errors;

    public UpsException(){

    }

    public UpsException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public UpsException(HttpStatus httpStatus, String message, List<ApiResponseErrorDto> errors){
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

}
