package com.drd.rdr_to_do_list.api.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class DiaryBundle {
    private DiaryBundle() {}

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Search {
        private int page;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddEdit {
        private String diaryName;
    }
}
