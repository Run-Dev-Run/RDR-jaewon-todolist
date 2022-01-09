package com.drd.rdr_to_do_list.api.diary.controller;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.ValidateResponse;
import com.drd.rdr_to_do_list.api.diary.service.DiaryValidateService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/diary/validate")
@RestController
public class DiaryValidateController extends DiaryValidateControllerForSwagger {
    private final DiaryValidateService diaryValidateService;

    @ResponseData(code = HttpStatus.OK, message = DiaryResponseMessage.VALIDATE_NAME)
    @GetMapping(name = "Diary 이름 검증", path = "name")
    public ValidateResponse name(
            @RequestParam("name") @ApiParam(value = "검증할 Diary 명", required = true) String name
    ) {
        boolean exists = diaryValidateService.existsName(name);
        return new ValidateResponse(!exists);
    }
}
