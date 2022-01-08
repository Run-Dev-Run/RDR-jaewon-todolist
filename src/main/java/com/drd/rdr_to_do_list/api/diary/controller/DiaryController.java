package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.PageResponseData;
import com.drd.rdr_to_do_list.api.common.domain.response.ResponseData;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.service.DiaryService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping("api/diary")
@RequiredArgsConstructor
@RestController
public class DiaryController extends DiaryControllerForSwagger {
    private final DiaryService diaryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(name = "Diary 목록 조회", path = { "", "/{pageNumber}" })
    public PageResponseData<DiaryResponse.ListItem> list(
            @PathVariable(value = "pageNumber", required = false) @ApiParam(value = "Page Number", example = "1") Integer pageNumber
    ) {
        Page<DiaryResponse.ListItem> page = diaryService.list(
                Objects.requireNonNullElse(pageNumber, 0)
        );
        return PageResponseData.fromPage(DiaryResponseMessage.PAGE, page);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(name = "Diary 추가")
    public ResponseData<String> add(
            @RequestParam("name") @ApiParam(value = "다이어리 이름", example = "2022년 할일", required = true) String name
    ) {
        diaryService.add(name);
        return ResponseData.of(DiaryResponseMessage.ADD);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(name = "Diary 정보 변경", path = "name")
    @Override
    public ResponseData<String> edit(@RequestBody DiaryRequest.Edit request) {
        // TODO
        return ResponseData.of(DiaryResponseMessage.EDIT);
    }
}
