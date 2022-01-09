package com.drd.rdr_to_do_list.api.diary.repository;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.drd.rdr_to_do_list.api.common.repository.AbstractQuerydslRepositorySupport;
import com.drd.rdr_to_do_list.api.diary.domain.Diary;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Objects;
import java.util.Optional;

import static com.drd.rdr_to_do_list.api.diary.domain.QDiary.diary;

@Repository
public class DiaryRepositoryImpl extends AbstractQuerydslRepositorySupport<Diary> implements DiaryRepository {
    public DiaryRepositoryImpl(final JPAQueryFactory factory, EntityManager entityManager) {
        super(Diary.class, factory, entityManager);
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
