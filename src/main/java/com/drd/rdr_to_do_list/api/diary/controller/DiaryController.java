package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.diary.converter.DiaryBundleConverter;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.service.DiaryService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping("api/diary")
@RequiredArgsConstructor
@RestController
public class DiaryController extends DiaryControllerForSwagger {
    private final DiaryBundleConverter diaryBundleConverter;
    private final DiaryService diaryService;

    @ResponseData(code = HttpStatus.OK, message = DiaryResponseMessage.PAGE)
    @GetMapping(name = "Diary 목록 조회", path = { "", "/{pageNumber}" })
    public PageResponse<DiaryResponse.ListItem> list(
            @PathVariable(value = "pageNumber", required = false) @ApiParam(value = "Page Number", example = "0") Integer pageNumber
    ) {
        Page<DiaryResponse.ListItem> page = diaryService.list(
                Objects.requireNonNullElse(pageNumber, 0)
        );
        return PageResponse.fromPage(page);
    }

    @ResponseData(code = HttpStatus.CREATED, messageOnly = true)
    @PostMapping(name = "Diary 추가")
    public String add(
            @RequestBody DiaryRequest.AddEdit request
    ) {
        DiaryBundle.Add addBundle = diaryBundleConverter.toAdd(request);
        diaryService.add(addBundle);

        return DiaryResponseMessage.ADD;
    }

    @ResponseData(code = HttpStatus.OK, messageOnly = true)
    @DeleteMapping(name = "Diary 삭제")
    @Override
    public String delete(
            @RequestParam("id") @ApiParam(value = "삭제할 다이어리 ID", example = "1", required = true) final long id
    ) {
        diaryService.delete(id);
        return DiaryResponseMessage.DELETE;
    }

    @ResponseData(code = HttpStatus.OK, messageOnly = true)
    @PutMapping(name = "Diary 정보 변경")
    @Override
    public String edit(
            @RequestBody DiaryRequest.AddEdit request
    ) {
        DiaryBundle.DetailEdit editBundle = diaryBundleConverter.toDetailEdit(request);
        diaryService.edit(request.getId(), editBundle);
        return DiaryResponseMessage.EDIT;
    }
}
