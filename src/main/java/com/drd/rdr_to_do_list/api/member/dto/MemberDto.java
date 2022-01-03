package com.drd.rdr_to_do_list.api.member.dto;

import com.drd.rdr_to_do_list.api.member.domain.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDto {
    private MemberDto() {}

    @Data
    @Builder
    @AllArgsConstructor
    public static class Info {
        private long id;
        private Auth auth;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class Auth implements UserDetails {
        private String username;
        private String password;
        private MemberRole role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return role.authorities();
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
