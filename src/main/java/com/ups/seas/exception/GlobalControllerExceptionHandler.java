package com.ups.seas.exception;

import com.ups.seas.utility.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Objects;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    public ApiResponseDto buildWithStatus(HttpStatus status) {
        return buildWithErrors(status, null);
    }

    private ApiResponseDto buildWithErrors(HttpStatus status, BindingResult bindingResult) {
        ApiResponseDto.ApiResponseDtoBuilder builder = new ApiResponseDto.ApiResponseDtoBuilder();
        builder.withStatus(status);
        if (Objects.nonNull(bindingResult) && bindingResult.hasFieldErrors()) {
            bindingResult.getFieldErrors().forEach((err) -> builder.withError(err.getField(), err.getDefaultMessage()));
        }
        return builder.build();
    }

    @ExceptionHandler(UpsException.class)
    public ResponseEntity<ApiResponseDto> handleUpsException(UpsException e){
        final ApiResponseDto.ApiResponseDtoBuilder builder = new ApiResponseDto.ApiResponseDtoBuilder();
        builder.withStatus(e.getHttpStatus());
        builder.withMessage(e.getMessage());
        builder.withErrors(Objects.nonNull(e.getErrors()) ? e.getErrors() : Collections.emptyList());
        ApiResponseDto apiResponseDto = builder.build();
        return new ResponseEntity<>(apiResponseDto, e.getHttpStatus());

    }
}





