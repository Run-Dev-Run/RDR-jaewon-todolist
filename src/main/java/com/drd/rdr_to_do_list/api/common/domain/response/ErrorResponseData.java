package com.drd.rdr_to_do_list.api.common.domain.response;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ApiModel(value = "오류 응답", parent = AbstractResponseData.class)
public class ErrorResponseData extends AbstractResponseData {
    public ErrorResponseData(final String message) {
        super(message);
    }

    @Override
    public ResponseEntity<ErrorResponseData> newResponseEntity(final HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
