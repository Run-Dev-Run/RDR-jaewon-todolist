package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.ResponseData;
import com.drd.rdr_to_do_list.api.common.domain.response.ResponseMediaType;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "Diary 조작 Controller")
public abstract class DiaryControllerForSwagger {
    @ApiOperation(value = "Diray 목록 조회")
    public abstract ResponseEntity<Void> list();

    @ApiResponses({
            @ApiResponse(code = 201,
                    message = "다이어리 추가 성공",
                    examples = @Example(
                            @ExampleProperty(mediaType = ResponseMediaType.JSON, value = DiaryResponseMessage.ADD)
                    )
            ),
            @ApiResponse(code = 409, message = "중복된 다이어리 명 추가 시도")
    })
    @ApiOperation(value = "Diary 추가")
    public abstract ResponseEntity<ResponseData> add(String name);
}
