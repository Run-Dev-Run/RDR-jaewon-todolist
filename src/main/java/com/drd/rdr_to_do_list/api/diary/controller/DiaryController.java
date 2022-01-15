package com.drd.rdr_to_do_list.api.diary.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.diary.converter.DiaryBundleConverter;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryRequest;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryResponse;
import com.drd.rdr_to_do_list.api.diary.service.DiaryService;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/diaries")
@RequiredArgsConstructor
@RestController
public class DiaryController extends DiaryControllerForSwagger {
    private final DiaryBundleConverter diaryBundleConverter;

    private final DiaryService diaryService;

    @ResponseData(code = HttpStatus.OK, message = DiaryResponseMessage.SEARCH)
    @GetMapping(name = "Diary 목록 조회", path = "search")
    @Override
    public PageResponse<DiaryResponse.ListItem> search(@ModelAttribute DiaryRequest.Search request) {
        DiaryBundle.Search searchBundle = diaryBundleConverter.toSearch(request);
        Page<DiaryResponse.ListItem> page = diaryService.list(searchBundle);
        return PageResponse.fromPage(page);
    }

    @ResponseData(code = HttpStatus.OK, message = DiaryResponseMessage.DETAIL)
    @GetMapping(name = "Diary 정보 조회", path = "{id}")
    @Override
    public DiaryResponse.Detail detail(@PathVariable("id") @ApiParam("다이어리 ID") long diaryId) {
        return diaryService.get(diaryId);
    }

    @ResponseData(code = HttpStatus.CREATED, messageOnly = true)
    @PostMapping(name = "Diary 추가")
    @Override
    public String add(@RequestBody DiaryRequest.AddEdit request) {
        DiaryBundle.AddEdit addBundle = diaryBundleConverter.toAdd(request);
        diaryService.add(addBundle);

        return DiaryResponseMessage.ADD;
    }

    @ResponseData(code = HttpStatus.OK, messageOnly = true)
    @DeleteMapping(name = "Diary 삭제")
    @Override
    public String delete(@RequestBody DiaryRequest.Delete request) {
        diaryService.delete(request.getId());
        return DiaryResponseMessage.DELETE;
    }

    @ResponseData(code = HttpStatus.OK, messageOnly = true)
    @PutMapping(name = "Diary 전체 정보 변경")
    @Override
    public String addEdit(@RequestBody DiaryRequest.AddEdit request) {
        DiaryBundle.AddEdit editBundle = diaryBundleConverter.toDetailEdit(request);
        diaryService.edit(request.getId(), editBundle);
        return DiaryResponseMessage.EDIT;
    }
}
