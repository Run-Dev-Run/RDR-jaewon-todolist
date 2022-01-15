package com.drd.rdr_to_do_list.api.todo.repository;

import static com.drd.rdr_to_do_list.api.todo.domain.QTodo.*;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.drd.rdr_to_do_list.api.common.domain.PageSize;
import com.drd.rdr_to_do_list.api.common.domain.Paging;
import com.drd.rdr_to_do_list.api.common.repository.AbstractQuerydslRepositorySupport;
import com.drd.rdr_to_do_list.api.todo.domain.Todo;
import com.drd.rdr_to_do_list.api.todo.dto.TodoBundle;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TodoRepositoryImpl extends AbstractQuerydslRepositorySupport<Todo> implements TodoRepository {
    protected TodoRepositoryImpl(JPAQueryFactory factory, EntityManager entityManager) {
        super(Todo.class, factory, entityManager);
    }

    @Override
    public Page<Todo> findPage(TodoBundle.Search bundle) {
        JPAQuery<Todo> query = factory.selectFrom(todo)
                                      .innerJoin(todo.diary)
                                      .where(todo.diary.name.eq(bundle.getDiaryName()));

        return super.findPage(query,
                              new Paging(PageSize.TODO_LIST, bundle.getPage()),
                              todo.createdDate.desc()
        );
    }
}
