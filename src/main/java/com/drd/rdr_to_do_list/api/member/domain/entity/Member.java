package com.drd.rdr_to_do_list.api.member.domain.entity;

import com.drd.rdr_to_do_list.api.common.domain.entity.AbstractEntity;
import com.drd.rdr_to_do_list.api.common.domain.entity.EntityConverter;
import com.drd.rdr_to_do_list.api.member.dto.MemberDto;
import lombok.Builder;

import javax.persistence.*;

@Table(name = "T_MEMBER")
@Entity
public class Member extends AbstractEntity<Member.Converter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long id;

    @Enumerated
    private MemberAuth auth;

    protected Member() {
    }

    @Builder
    public Member(final MemberAuth auth) {
        this.auth = auth;
    }

    @Override
    public Member.Converter converter() {
        return new Converter(this);
    }

    public static class Converter implements EntityConverter {
        private final Member member;

        public Converter(final Member member) {
            this.member = member;
        }

        public MemberDto.Info toInfo() {
            return MemberDto.Info.builder()
                    .id(member.id)
                    .auth(toAuth())
                    .build();
        }

        public MemberDto.Auth toAuth() {
            return member.auth
                    .converter()
                    .toAuth();
        }
    }
}
