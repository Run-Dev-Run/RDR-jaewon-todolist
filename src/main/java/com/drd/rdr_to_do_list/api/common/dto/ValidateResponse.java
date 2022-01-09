package com.drd.rdr_to_do_list.api.common.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Validate Response DTO")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ValidateResponse {
    @ApiModelProperty(value = "유효성 검증 결과", dataType = "Boolean", required = true)
    private final boolean valid;

    public ValidateResponse(final boolean valid) {
        this.valid = valid;
    }
}
