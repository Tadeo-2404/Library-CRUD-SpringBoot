package com.app.crud.configuration;

import com.app.crud.model.member.Member;
import com.app.crud.model.member.Role;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Array;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.getByUsername(username);
        if(member != null) {
            return User.builder()
                    .username(member.getUsername())
                    .password(member.getPassword())
                    .roles(getRoles(member))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(Member member) {
        if (member.getRoles().isEmpty()) {
            return new String[]{"USER"};
        }

        return member.getRoles()
                .stream()
                .map(role -> role.getName().toString()) // Assuming getName() returns ERole enum
                .toArray(String[]::new);
    }
}
