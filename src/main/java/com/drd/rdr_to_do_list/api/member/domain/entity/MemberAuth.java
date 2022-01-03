package com.drd.rdr_to_do_list.api.member.domain.entity;

import com.drd.rdr_to_do_list.api.common.domain.entity.EntityBase;
import com.drd.rdr_to_do_list.api.common.domain.entity.EntityConverter;
import com.drd.rdr_to_do_list.api.member.dto.MemberDto;

import javax.persistence.*;

@Embeddable
public class MemberAuth implements EntityBase<MemberAuth.Converter> {
    @Column(name = "MEMBER_USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "MEMBER_PASSWORD", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Override
    public MemberAuth.Converter converter() {
        return new Converter(this);
    }

    public static class Converter implements EntityConverter {
        private final MemberAuth auth;

        public Converter(final MemberAuth auth) {
            this.auth = auth;
        }

        public MemberDto.Auth toAuth() {
            return MemberDto.Auth.builder()
                    .username(auth.username)
                    .password(auth.password)
                    .role(auth.role)
                    .build();
        }
    }
}
