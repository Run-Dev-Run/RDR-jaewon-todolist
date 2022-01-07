package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.domain.response.ResponseData;
import com.drd.rdr_to_do_list.api.diary.service.DiaryService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/diary")
@RequiredArgsConstructor
@RestController
public class DiaryController extends DiaryControllerForSwagger {
    private final DiaryService diaryService;

    @GetMapping(name = "Diary 목록")
    public ResponseEntity<Void> list() {
        return null;
    }

    // ModelAttribute 대신 RequestBody 쓰기
    @PostMapping(name = "Diary 추가")
    public ResponseEntity<ResponseData> add(
            @ApiParam(value = "다이어리 이름", example = "2022년 할일", required = true) @RequestParam("name") String name
    ) {
        diaryService.add(name);
        return new ResponseData(DiaryResponseMessage.ADD)
                .newResponseEntity(HttpStatus.CREATED);
    }
}
