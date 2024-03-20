package com.app.crud.model.member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "member")
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "memberId", unique = true, nullable = false)
    private String memberId;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "username", nullable = false, length = 250)
    private String username;
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "lastname", nullable = false, length = 250)
    private String lastname;
    @Column(name = "age", nullable = true)
    private int age;

    @ManyToMany(
            fetch = FetchType.EAGER,
            targetEntity = Role.class,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "member_roles",
            joinColumns = @JoinColumn(name = "member_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false)

    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = this.getRoles(); // Assuming getRoles() returns a Set<Object>
        return roles.stream()
                .map(Role::toString) // Convert roles to String
                .map(SimpleGrantedAuthority::new) // Create SimpleGrantedAuthority objects
                .collect(Collectors.toList()); // Collect into a List
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
