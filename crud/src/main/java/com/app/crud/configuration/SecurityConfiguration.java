package com.app.crud.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
           registry.requestMatchers("/api/v1/books").permitAll();
           registry.requestMatchers("/api/v1/addresses").hasRole("CLIENT");
           registry.requestMatchers("/api/v1/loans").hasRole("CLIENT");
           registry.requestMatchers("/api/v1/members").hasRole("CLIENT");
           registry.requestMatchers("/api/v1/members").hasRole("ADMIN");
           registry.requestMatchers("/api/v1/memberBooks").hasRole("ADMIN");
           registry.anyRequest().authenticated();
        })
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails normal = User.builder()
//                .username("puppy")
//                .password("$2a$12$j2UShNbNdiTz3hW2sKHs9eREDRsm7OACa3gDwX3svFTD7Fok2f6.6")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$12$j2UShNbNdiTz3hW2sKHs9eREDRsm7OACa3gDwX3svFTD7Fok2f6.6")
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(normal, admin);
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}