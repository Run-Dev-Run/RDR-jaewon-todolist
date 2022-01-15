package com.drd.rdr_to_do_list.api.todo.converter;

import org.springframework.stereotype.Component;

import com.drd.rdr_to_do_list.api.todo.dto.TodoBundle;
import com.drd.rdr_to_do_list.api.todo.dto.TodoRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TodoBundleConverter {
    public TodoBundle.Search toSearch(TodoRequest.Search request) {
        return TodoBundle.Search.builder()
            .page(request.getPage())
            .diaryName(request.getDiaryName())
            .build();
    }
}
