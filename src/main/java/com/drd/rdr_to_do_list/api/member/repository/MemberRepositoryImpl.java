package com.drd.rdr_to_do_list.api.member.repository;

import com.drd.rdr_to_do_list.api.member.domain.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepository {
    private final JPAQueryFactory factory;

    public MemberRepositoryImpl(final JPAQueryFactory factory) {
        super(Member.class);
        this.factory = factory;
    }

    @Override
    public Optional<Member> findByEmail(final String email) {
        return Optional.empty();
    }
}
