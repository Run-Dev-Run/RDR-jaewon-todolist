package com.drd.rdr_to_do_list.api.diary.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Diary 검증 Controller")
public abstract class DiaryValidateControllerForSwagger {
    @ApiResponses({
        @ApiResponse(
            code = 200, message = DiaryResponseMessage.VALID_NAME
        ),
        @ApiResponse(
            code = 409, message = DiaryResponseMessage.NOT_VALID_NAME
        )
    })
    @ApiOperation(value = "Diray 이름 사용 가능 여부")
    public abstract String name(String name);
}
