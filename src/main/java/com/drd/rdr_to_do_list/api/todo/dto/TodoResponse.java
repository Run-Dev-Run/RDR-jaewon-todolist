package com.drd.rdr_to_do_list.api.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class TodoResponse {
    private TodoResponse() {
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ListItem {
        private long id;
        private String subject;
        private boolean completed;
    }
}
