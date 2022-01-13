package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.ResponseMediaType;
import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@Api(tags = "Diary 조작 Controller")
public abstract class DiaryControllerForSwagger {
    @ApiResponses({
        @ApiResponse(code = 200, message = DiaryResponseMessage.PAGE)
    })
    @ApiOperation(value = "Diray 목록 조회")
    public abstract PageResponse<DiaryResponse.ListItem> search(DiaryRequest.Search request);

    @ApiResponses({
        @ApiResponse(code = 200, message = DiaryResponseMessage.DETAIL)
    })
    @ApiOperation(value = "Diray 정보 조회")
    public abstract DiaryResponse.Detail detail(long diaryId);

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
            @ApiResponse(code = 406, message = DiaryResponseMessage.NOT_FOUND_DIARY)
    })
    @ApiOperation(value = "Diary 정보 변경")
    public abstract String addEdit(DiaryRequest.AddEdit request);

    @ApiResponses({
            @ApiResponse(code = 200, message = DiaryResponseMessage.DELETE),
            @ApiResponse(code = 406, message = DiaryResponseMessage.NOT_FOUND_DIARY)
    })
    @ApiOperation(value = "Diary 삭제")
    public abstract String delete(DiaryRequest.Delete request);
}
