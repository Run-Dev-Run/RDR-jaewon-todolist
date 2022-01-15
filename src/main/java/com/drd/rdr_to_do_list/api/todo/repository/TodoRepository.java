package com.drd.rdr_to_do_list.api.todo.repository;

import org.springframework.data.domain.Page;

import com.drd.rdr_to_do_list.api.todo.domain.Todo;
import com.drd.rdr_to_do_list.api.todo.dto.TodoBundle;

public interface TodoRepository {
    Page<Todo> findPage(TodoBundle.Search bundle);

    void save(Todo todo);
}
