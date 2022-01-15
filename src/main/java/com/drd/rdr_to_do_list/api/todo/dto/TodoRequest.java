package com.drd.rdr_to_do_list.api.todo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

public class TodoRequest {
    private TodoRequest() {}

    @Data
    public static class Search {
        @ApiModelProperty(value = "Page Number", example = "0")
        private int page;
        @ApiModelProperty(value = "조회할 다이어리 명", example = "2022년 할일")
        private String diaryName;
    }
}
