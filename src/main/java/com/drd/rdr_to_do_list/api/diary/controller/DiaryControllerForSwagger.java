package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.ResponseMediaType;
import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.exception.DiaryErrorMessage;
import io.swagger.annotations.*;

@Api(tags = "Diary 조작 Controller")
public abstract class DiaryControllerForSwagger {
    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.PAGE)
    })
    @ApiOperation(value = "Diray 목록 조회")
    public abstract PageResponse<DiaryResponse.ListItem> list(Integer pageNumber);

    @ApiResponses({
            @ApiResponse(code = 201,
                    message = "다이어리 추가 성공",
                    examples = @Example(
                            @ExampleProperty(mediaType = ResponseMediaType.JSON, value = DiaryResponseMessage.ADD)
                    )
            )
    })
    @ApiOperation(value = "Diary 추가")
    public abstract String add(DiaryRequest.AddEdit request);

    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.EDIT),
            @ApiResponse(code = 406, message = DiaryErrorMessage.DIARY_NOT_FOUND)
    })
    @ApiOperation(value = "Diary 정보 변경")
    public abstract String edit(DiaryRequest.AddEdit request);

    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.DELETE),
            @ApiResponse(code = 406, message = DiaryErrorMessage.DIARY_NOT_FOUND)
    })
    @ApiOperation(value = "Diary 삭제")
    public abstract String delete(long id);
}
