package com.drd.rdr_to_do_list.api.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class TodoBundle {
    private TodoBundle() {
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Search {
        private int page;
        private String diaryName;
    }
}
