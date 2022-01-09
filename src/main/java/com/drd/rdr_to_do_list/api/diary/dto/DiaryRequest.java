package com.drd.rdr_to_do_list.api.diary.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

public class DiaryRequest {
    private DiaryRequest() {}

    @ApiModel("다이어리 정보 추가 또는 변경 Request")
    @Data
    public static class AddEdit {
        @ApiModelProperty(value = "다이어리 ID", example = "1")
        private long id;

        @ApiModelProperty(value = "다이어리 이름", example = "2022년의 다이어리", required = true)
        private String name;
    }
}
