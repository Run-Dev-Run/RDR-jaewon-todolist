package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class QDiaryRepositoryImpl extends QuerydslRepositorySupport implements QDiaryRepository {
    private final JPAQueryFactory factory;

    public QDiaryRepositoryImpl(final JPAQueryFactory factory) {
        super(Diary.class);
        this.factory = factory;
    }
}
