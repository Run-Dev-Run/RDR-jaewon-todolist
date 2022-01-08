package com.drd.rdr_to_do_list.api.common.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(value = "공통 응답")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseData<R> {
    @ApiModelProperty(value = "응답 메시지", dataType = "String", required = true, example = "API가 응답 했습니다.")
    private final String message;
    @ApiModelProperty(value = "응답 데이터", dataType = "Object")
    private final R data;
    @ApiModelProperty(value = "응답 시간", dataType = "Date", required = true, example = "2022-01-08T18:26:52.540075")
    private final LocalDateTime time;

    public CommonResponseData(final String message, final R data) {
        this.message = message;
        this.data = data;
        this.time = LocalDateTime.now();
    }

    public CommonResponseData(final String message) {
        this(message, null);
    }
}
