package com.drd.rdr_to_do_list.api.common.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.ErrorResponseData;
import com.drd.rdr_to_do_list.api.common.exception.CommonErrorMessage;
import com.drd.rdr_to_do_list.api.common.exception.DuplicateAggregateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonControllerAdvice {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateAggregateException.class)
    public ErrorResponseData duplicateAggregate(Exception e) {
        return ErrorResponseData.fromException(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseData> other(Exception e) {
        e.printStackTrace();
        return ErrorResponseData.of(CommonErrorMessage.EXCEPTION.message())
                .newResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
