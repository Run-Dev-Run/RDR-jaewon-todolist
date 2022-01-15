package com.drd.rdr_to_do_list.api.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drd.rdr_to_do_list.api.common.annotation.ResponseData;
import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.todo.converter.TodoBundleConverter;
import com.drd.rdr_to_do_list.api.todo.dto.TodoBundle;
import com.drd.rdr_to_do_list.api.todo.dto.TodoRequest;
import com.drd.rdr_to_do_list.api.todo.dto.TodoResponse;
import com.drd.rdr_to_do_list.api.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequestMapping("api/todos")
@RequiredArgsConstructor
@RestController
public class TodoController extends TodoControllerForSwagger {
    private final TodoBundleConverter todoBundleConverter;

    private final TodoService todoService;

    @ResponseData(code = HttpStatus.OK, message = TodoResponseMessage.SEARCH)
    @GetMapping("search")
    @Override
    public PageResponse<TodoResponse.ListItem> search(@ModelAttribute TodoRequest.Search request) {
        TodoBundle.Search searchBundle = todoBundleConverter.toSearch(request);
        return PageResponse.fromPage(todoService.search(searchBundle));
    }
}
