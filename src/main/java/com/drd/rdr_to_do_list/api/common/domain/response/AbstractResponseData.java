package com.drd.rdr_to_do_list.api.common.domain.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResponseData {
    @ApiModelProperty(value = "응답 시간", dataType = "Date", required = true, example = "2022-01-08T18:26:52.540075")
    private final LocalDateTime time;

    @ApiModelProperty(value = "응답 메시지", dataType = "String", required = true, example = "API가 응답 했습니다.")
    private final String message;

    public AbstractResponseData(String message) {
        this.time = LocalDateTime.now();
        this.message = message;
    }
}
