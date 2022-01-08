package com.drd.rdr_to_do_list.api.common.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.ErrorResponseData;
import com.drd.rdr_to_do_list.api.common.exception.CommonErrorMessage;
import com.drd.rdr_to_do_list.api.common.exception.WithResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseData> hideException(Exception e) {
        e.printStackTrace();
        return new ErrorResponseData(CommonErrorMessage.EXCEPTION.message())
                .newResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WithResponseException.class)
    public ResponseEntity<ErrorResponseData> withResponseException(Exception e) {
        WithResponseException castedException = (WithResponseException) e;
        return new ErrorResponseData(castedException.message())
                .newResponseEntity(castedException.status());
    }
}