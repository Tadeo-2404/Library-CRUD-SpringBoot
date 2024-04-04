package com.app.crud.model.member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            targetEntity = Permission.class,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "member_permissions",
            joinColumns = @JoinColumn(name = "member_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permission_id", nullable = false)

    )
    private Set<Permission> permissions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role: this.roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName().toString());
            authorityList.add(authority);
        }
        return authorityList;
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
