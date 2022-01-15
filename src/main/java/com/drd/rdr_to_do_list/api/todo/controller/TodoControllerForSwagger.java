package com.drd.rdr_to_do_list.api.todo.controller;

import com.drd.rdr_to_do_list.api.common.dto.PageResponse;
import com.drd.rdr_to_do_list.api.todo.dto.TodoRequest;
import com.drd.rdr_to_do_list.api.todo.dto.TodoResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "ToDo Controller")
public abstract class TodoControllerForSwagger {
    @ApiResponses({
        @ApiResponse(code = 200, message = TodoResponseMessage.SEARCH)
    })
    @ApiOperation(value = "TODO 검색")
    public abstract PageResponse<TodoResponse.ListItem> search(TodoRequest.Search request);
}
