package com.drd.rdr_to_do_list.api.member.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

public enum MemberRole {
    BASIC(new SimpleGrantedAuthority("BASIC"));

    private final List<GrantedAuthority> authorities;

    MemberRole(final List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    MemberRole(final GrantedAuthority authority) {
        this(List.of(authority));
    }

    public List<GrantedAuthority> authorities() {
        return authorities;
    }
}
