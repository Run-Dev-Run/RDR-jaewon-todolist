package com.drd.rdr_to_do_list.api.common.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ApiModel(value = "일반적인 요청에 대한 응답", parent = AbstractResponseData.class)
public class ResponseData<R> extends AbstractResponseData {
    @ApiModelProperty(value = "응답 데이터", dataType = "Object")
    private final R data;

    private ResponseData(final String message, final R data) {
        super(message);
        this.data = data;
    }

    public static <R> ResponseData<R> of(final String message, final R data) {
        return new ResponseData<>(message, data);
    }

    public static ResponseData<String> of(final String message) {
        return of(message, null);
    }

    @Override
    public ResponseEntity<ResponseData<R>> newResponseEntity(final HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
