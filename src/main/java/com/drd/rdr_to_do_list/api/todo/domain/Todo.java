package com.drd.rdr_to_do_list.api.todo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.drd.rdr_to_do_list.api.common.annotation.EntityDetail;
import com.drd.rdr_to_do_list.api.common.domain.entity.AbstractEntity;
import com.drd.rdr_to_do_list.api.common.domain.entity.EntityConverter;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.todo.dto.TodoResponse;

import lombok.Builder;

@EntityDetail(nameForException = "할 일")
@Entity
public class Todo extends AbstractEntity<Todo.Converter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TODO_DIARY", nullable = false)
    private Diary diary;

    @Column(name = "TODO_SUBJECT", length = 100, nullable = false)
    private String subject;

    @Lob
    @Column(name = "TODO_CONTENT", nullable = false)
    private String content;

    @Column(name = "TODO_COMPLETED", nullable = false)
    private boolean completed;

    protected Todo() {
    }

    @Builder
    public Todo(Diary diary, String subject, String content) {
        this.diary = diary;
        this.subject = subject;
        this.content = content;

        this.completed = false;
    }

    @Override
    public Converter converter() {
        return new Converter(this);
    }

    public static class Converter implements EntityConverter {
        private final Todo todo;

        public Converter(Todo todo) {
            this.todo = todo;
        }

        public TodoResponse.ListItem toListItem() {
            return TodoResponse.ListItem.builder()
                .id(todo.id)
                .subject(todo.subject)
                .completed(todo.completed)
                .build();
        }
    }
}
