package com.drd.rdr_to_do_list.api.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ResponseData {
    private final LocalDateTime time;

    public ResponseData() {
        this.time = LocalDateTime.now();
    }

    public ResponseEntity<ResponseData> newResponseEntity(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
