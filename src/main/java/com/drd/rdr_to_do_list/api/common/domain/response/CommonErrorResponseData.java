package com.drd.rdr_to_do_list.api.common.domain.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonErrorResponseData extends ResponseData {
    private final String message;

    public CommonErrorResponseData(final String message) {
        this.message = message;
    }
}
