package com.drd.rdr_to_do_list.api.diary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.exception.DuplicateException;
import com.drd.rdr_to_do_list.api.diary.service.DiaryValidateService;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/diary/validate")
@RestController
public class DiaryValidateController extends DiaryValidateControllerForSwagger {
    private final DiaryValidateService diaryValidateService;

    @ResponseData(code = HttpStatus.OK, message = DiaryResponseMessage.VALID_NAME)
    @GetMapping(name = "Diary 이름 검증", path = "name/{diaryName}")
    public String name(@PathVariable("diaryName") @ApiParam(value = "검증할 Diary 명", required = true) String diaryName) {
        if (diaryValidateService.existsName(diaryName)) {
            throw new DuplicateException(DiaryResponseMessage.NOT_VALID_NAME);
        }
        return DiaryResponseMessage.VALID_NAME;
    }
}
