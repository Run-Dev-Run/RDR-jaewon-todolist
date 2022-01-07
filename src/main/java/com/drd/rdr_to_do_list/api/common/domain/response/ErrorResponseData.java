package com.drd.rdr_to_do_list.api.common.domain.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseData extends AbstractResponseData {
    // TODO Cache 추가
    private final String message;

    public ErrorResponseData(final String message) {
        this.message = message;
    }

    @Override
    public ResponseEntity<ErrorResponseData> newResponseEntity(final HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
