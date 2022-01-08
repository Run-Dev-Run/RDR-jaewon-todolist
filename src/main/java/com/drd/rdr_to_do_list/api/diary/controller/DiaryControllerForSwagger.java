package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.PageResponseData;
import com.drd.rdr_to_do_list.api.common.domain.response.ResponseData;
import com.drd.rdr_to_do_list.api.common.domain.response.ResponseMediaType;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.exception.DiaryErrorMessage;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "Diary 조작 Controller")
public abstract class DiaryControllerForSwagger {
    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.PAGE)
    })
    @ApiOperation(value = "Diray 목록 조회")
    public abstract PageResponseData<DiaryResponse.ListItem> list(Integer pageNumber);

    @ApiResponses({
            @ApiResponse(code = 201,
                    message = "다이어리 추가 성공",
                    examples = @Example(
                            @ExampleProperty(mediaType = ResponseMediaType.JSON, value = DiaryResponseMessage.ADD)
                    )
            ),
            @ApiResponse(code = 409, message = DiaryErrorMessage.DUPLICATE_DIARY_NAME)
    })
    @ApiOperation(value = "Diary 추가")
    public abstract ResponseData<String> add(String name);

    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.EDIT)
    })
    @ApiOperation(value = "Diary 정보 변경")
    public abstract ResponseData<String> edit(DiaryRequest.Edit request);
}
