package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.dto.ValidateResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "Diary 검증 Controller")
public abstract class DiaryValidateControllerForSwagger {
    @ApiResponse(
            code = 200, message = DiaryResponseMessage.VALIDATE_NAME
    )
    @ApiOperation(value = "Diray 이름 사용 가능 여부")
    public abstract ValidateResponse name(String name);
}
