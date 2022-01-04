package com.drd.rdr_to_do_list.api.member.service;

import com.drd.rdr_to_do_list.api.common.exception.ErrorMessage;
import com.drd.rdr_to_do_list.api.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberAuthService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        return memberRepository.findByEmail(s)
                .map(iMember -> iMember.converter().toAuth())
                .orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.NOT_FOUND_USERNAME.message()));
    }
}
