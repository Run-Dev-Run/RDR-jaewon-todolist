package com.drd.rdr_to_do_list.api.diary.repository;

import static com.drd.rdr_to_do_list.api.diary.domain.QDiary.*;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.drd.rdr_to_do_list.api.common.domain.Paging;
import com.drd.rdr_to_do_list.api.common.domain.PageSize;
import com.drd.rdr_to_do_list.api.common.repository.AbstractQuerydslRepositorySupport;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.drd.rdr_to_do_list.api.diary.dto.DiaryBundle;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DiaryRepositoryImpl extends AbstractQuerydslRepositorySupport<Diary> implements DiaryRepository {
    public DiaryRepositoryImpl(final JPAQueryFactory factory, EntityManager entityManager) {
        super(Diary.class, factory, entityManager);
    }

    @Override
    public Page<Diary> findPage(final DiaryBundle.Search bundle) {
        JPAQuery<Diary> query = factory.selectFrom(diary)
                .where(diary.deleted.isFalse());

        return super.findPage(
                query,
                new Paging(PageSize.DIARY_LIST, bundle.getPage()),
                diary.createdDate.desc()
        );
    }

    @Override
    public Optional<Diary> findById(final long id) {
        return Optional.ofNullable(
                factory.selectFrom(diary)
                        .where(
                                diary.id.eq(id),
                                diary.deleted.isFalse()
                        )
                        .fetchFirst()
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
