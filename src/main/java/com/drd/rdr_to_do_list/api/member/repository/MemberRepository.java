package com.drd.rdr_to_do_list.api.member.repository;

import com.drd.rdr_to_do_list.api.member.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findByEmail(String email);
}
