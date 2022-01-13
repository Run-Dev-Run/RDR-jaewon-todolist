package com.drd.rdr_to_do_list.api.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.drd.rdr_to_do_list.api.common.dto.CommonResponseData;
import com.drd.rdr_to_do_list.api.common.exception.CommonErrorMessage;
import com.drd.rdr_to_do_list.api.common.exception.DuplicateException;
import com.drd.rdr_to_do_list.api.common.exception.entitynotfound.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(EntityNotFoundException.class)
    public CommonResponseData<Void> entityNotFoundException(Exception e) {
        return new CommonResponseData<>(e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateException.class)
    public CommonResponseData<Void> duplicateException(Exception e) {
        return new CommonResponseData<>(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CommonResponseData<Void> other(Exception e) {
        e.printStackTrace();
        return new CommonResponseData<>(CommonErrorMessage.COMMON.message());
    }
}
