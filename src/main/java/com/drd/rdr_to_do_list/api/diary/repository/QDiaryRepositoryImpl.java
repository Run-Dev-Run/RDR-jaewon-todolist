package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.common.repository.AbstractQuerydslRepositorySupport;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static com.drd.rdr_to_do_list.api.diary.domain.QDiary.diary;

@Repository
public class QDiaryRepositoryImpl extends AbstractQuerydslRepositorySupport<Diary> implements QDiaryRepository {
    public QDiaryRepositoryImpl(final JPAQueryFactory factory) {
        super(Diary.class, factory);
    }

    @Override
    public Page<Diary> findPage(final PageBundle pageBundle) {
        JPAQuery<Diary> query = factory.selectFrom(diary)
                .where(diary.deleted.isFalse());

        return super.findPage(
                query,
                pageBundle,
                diary.createdDate.desc()
        );
    }

    @Override
    public boolean existsName(final String name) {
        return Objects.nonNull(
                factory.selectFrom(diary)
                        .where(
                                diary.name.eq(name),
                                diary.deleted.isFalse()
                        )
                        .fetchFirst()
        );
    }
}
