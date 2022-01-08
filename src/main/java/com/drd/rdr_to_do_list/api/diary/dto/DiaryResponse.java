package com.drd.rdr_to_do_list.api.diary.dto;

import com.drd.rdr_to_do_list.api.common.domain.response.AbstractResponseData;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.time.LocalDateTime;

public class DiaryResponse {
    private DiaryResponse() {}

    @ApiModel(value = "다이어리 List Item")
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListItem {
        @ApiModelProperty(value = "Diary ID", dataType = "Number", example = "1")
        private final long id;

        @ApiModelProperty(value = "Diary 이름", dataType = "String", example = "2022년의 계획")
        private final String name;

        @ApiModelProperty(value = "Diary 생성 일자", dataType = "Date", example = "2022-01-08T18:26:52.540075")
        private final LocalDateTime createdTime;

        @Builder
        public ListItem(final long id, final String name, final LocalDateTime createdTime) {
            this.id = id;
            this.name = name;
            this.createdTime = createdTime;
        }
    }
}
