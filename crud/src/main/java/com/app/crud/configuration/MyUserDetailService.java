package com.app.crud.configuration;

import com.app.crud.model.member.Member;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailService implements UserDetailsService {
    private final Map<String, UserDetails> inMemoryUsers = new HashMap<>();

    @Autowired
    private MemberRepository memberRepository;

    public MyUserDetailService() {
        // Add in-memory users here
        UserDetails normalUser = User.withUsername("puppy")
                .password("$2a$12$j2UShNbNdiTz3hW2sKHs9eREDRsm7OACa3gDwX3svFTD7Fok2f6.6")
                .roles("USER")
                .build();
        UserDetails adminUser = User.withUsername("admin")
                .password("$2a$12$j2UShNbNdiTz3hW2sKHs9eREDRsm7OACa3gDwX3svFTD7Fok2f6.6")
                .roles("ADMIN", "USER")
                .build();

        inMemoryUsers.put(normalUser.getUsername(), normalUser);
        inMemoryUsers.put(adminUser.getUsername(), adminUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails member = inMemoryUsers.get(username);
        if(member != null) {
            return member;
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
