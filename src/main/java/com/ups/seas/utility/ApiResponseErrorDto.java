package com.ups.seas.utility;

import lombok.Data;

@Data
public class ApiResponseErrorDto {

    private String field;
    private String errorMessage;

    public ApiResponseErrorDto () {

    }

    public ApiResponseErrorDto(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ApiResponseErrorDto{" +
                "field='" + field + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

