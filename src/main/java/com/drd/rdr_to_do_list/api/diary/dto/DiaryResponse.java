package com.drd.rdr_to_do_list.api.diary.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

public class DiaryResponse {
    private DiaryResponse() {}

    @ApiModel(value = "다이어리 List Item")
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListItem {
        @ApiModelProperty(value = "Diary ID", dataType = "Number", example = "1")
        private final long id;

        @ApiModelProperty(value = "Diary 이름", dataType = "String", example = "2022년의 계획")
        private final String diaryName;

        @ApiModelProperty(value = "Diary 생성 일자", dataType = "Date", example = "2022-01-08T18:26:52.540075")
        private final LocalDateTime createdTime;

        @Builder
        public ListItem(final long id, final String diaryName, final LocalDateTime createdTime) {
            this.id = id;
            this.diaryName = diaryName;
            this.createdTime = createdTime;
        }
    }

    @ApiModel(value = "다이어리 Detail")
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Detail {
        @ApiModelProperty(value = "Diary ID", dataType = "Number", example = "1")
        private final long id;

        @ApiModelProperty(value = "Diary 이름", dataType = "String", example = "2022년의 계획")
        private final String diaryName;

        @Builder
        public Detail(long id, String diaryName) {
            this.id = id;
            this.diaryName = diaryName;
        }
    }
}
