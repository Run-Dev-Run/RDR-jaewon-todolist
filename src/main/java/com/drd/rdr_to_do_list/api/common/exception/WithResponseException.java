package com.drd.rdr_to_do_list.api.common.exception;

import org.springframework.http.HttpStatus;

public abstract class WithResponseException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    protected WithResponseException(final HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus status() {
        return status;
    }

    public String message() {
        return message;
    }
}
