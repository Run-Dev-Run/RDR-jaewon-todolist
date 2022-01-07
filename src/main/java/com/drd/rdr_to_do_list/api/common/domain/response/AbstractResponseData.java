package com.drd.rdr_to_do_list.api.common.domain.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResponseData {
    private final LocalDateTime time;

    public AbstractResponseData() {
        this.time = LocalDateTime.now();
    }

    public abstract ResponseEntity<?> newResponseEntity(HttpStatus status);
}
