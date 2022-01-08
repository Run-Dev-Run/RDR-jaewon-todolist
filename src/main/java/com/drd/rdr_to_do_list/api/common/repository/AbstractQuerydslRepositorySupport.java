package com.drd.rdr_to_do_list.api.common.repository;

import com.drd.rdr_to_do_list.api.common.domain.PageBundle;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Objects;

public abstract class AbstractQuerydslRepositorySupport<T> extends QuerydslRepositorySupport {
    protected final JPAQueryFactory factory;

    protected AbstractQuerydslRepositorySupport(final Class<T> domainClass, final JPAQueryFactory factory) {
        super(domainClass);
        this.factory = factory;
    }

    protected final <R> Page<R> findPage(JPAQuery<R> query, PageBundle pageBundle, OrderSpecifier<?> orderBy) {
        long fetchCount = query.fetchCount();

        Pageable pageable = pageBundle.toPageable(fetchCount);
        if (Objects.nonNull(orderBy)) {
            query = query.orderBy(orderBy);
        }
        List<R> fetched = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(fetched, pageable, fetchCount);
    }
}