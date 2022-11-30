package com.ups.seas.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(value = NON_NULL,content = NON_EMPTY)
public class ApiResponseDto {

    private int statusCode;
    private HttpStatus httpStatus;
    private String message;
    private Object data;
    private List<ApiResponseErrorDto> errors;

    private ApiResponseDto(ApiResponseDtoBuilder builder) {
        this.httpStatus = builder.httpStatus;
        this.statusCode = httpStatus.value();
        this.message = builder.message;
        this.data= builder.data;
        this.errors = builder.errors.isEmpty() ? null : builder.errors;
    }

    public static class ApiResponseDtoBuilder{
        private HttpStatus httpStatus;
        private String message;
        private Object data;
        private List<ApiResponseErrorDto> errors;

        public ApiResponseDtoBuilder() {
            this.errors = new ArrayList<ApiResponseErrorDto>();
        }

        public ApiResponseDtoBuilder withStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ApiResponseDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseDtoBuilder withData( Object data) {
            this.data = data;
            return this;
        }

        public ApiResponseDtoBuilder withError(String filed, String message){
            this.errors.add(new ApiResponseErrorDto(filed, message));
            return this;
        }

        public ApiResponseDtoBuilder withError(ApiResponseErrorDto error){
            this.errors.add(error);
            return this;
        }

        public ApiResponseDtoBuilder withErrors(List<ApiResponseErrorDto> errors){
            this.errors = errors;
            return this;
        }

        public boolean hasNoErrors(){
           return this.errors.isEmpty();
        }

        public ApiResponseDto build(){
            return new ApiResponseDto(this);
        }
    }


}
