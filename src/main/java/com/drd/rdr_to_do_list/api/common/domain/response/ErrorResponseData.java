package com.drd.rdr_to_do_list.api.common.domain.response;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ApiModel(value = "오류 응답", parent = AbstractResponseData.class)
public class ErrorResponseData extends AbstractResponseData {
    private ErrorResponseData(final String message) {
        super(message);
    }

    public static ErrorResponseData fromException(Exception e) {
        return new ErrorResponseData(e.getMessage());
    }

    public static ErrorResponseData of(String message) {
        return new ErrorResponseData(message);
    }
}
