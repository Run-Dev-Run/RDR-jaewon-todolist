package com.drd.rdr_to_do_list.api.common.domain.response;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ApiModel(value = "일반적인 정상 응답 DTO", parent = AbstractResponseData.class)
public class ResponseData extends AbstractResponseData {
    private final String message;
    private final Object data;

    public ResponseData(final String message, final Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseData(final String message) {
        this(message, null);
    }

    @Override
    public ResponseEntity<ResponseData> newResponseEntity(final HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
