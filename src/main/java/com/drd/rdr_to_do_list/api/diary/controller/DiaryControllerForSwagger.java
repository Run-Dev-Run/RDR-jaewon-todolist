package com.drd.rdr_to_do_list.api.diary.controller;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "Diary 조작 Controller")
public abstract class DiaryControllerForSwagger {
    @ApiOperation(value = "Diray 조회")
    public abstract ResponseEntity<Void> list();

    @ApiResponses({
            @ApiResponse(code = 201, message = "다이어리 추가 성공"),
            @ApiResponse(code = 409, message = "중복된 다이어리 명 추가 시도")
    })
    @ApiOperation(value = "Diary 추가")
    public abstract ResponseEntity<Void> add(
            @ApiParam(value = "다이어리 이름", required = true) String name
    );
}
