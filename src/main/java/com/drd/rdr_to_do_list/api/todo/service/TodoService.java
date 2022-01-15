package com.drd.rdr_to_do_list.api.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.drd.rdr_to_do_list.api.todo.domain.Todo;
import com.drd.rdr_to_do_list.api.todo.dto.TodoBundle;
import com.drd.rdr_to_do_list.api.todo.dto.TodoResponse;
import com.drd.rdr_to_do_list.api.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public Page<TodoResponse.ListItem> search(TodoBundle.Search bundle) {
        return todoRepository.findPage(bundle)
                             .map(Todo::converter)
                             .map(Todo.Converter::toListItem);
    }
}
