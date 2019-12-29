package com.drapala.quiz2.security;

import com.drapala.quiz2.model.User;
import com.drapala.quiz2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final String[] WHITELIST = {
            "/login"
    };

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        saveDefaultUser();
        User admin = userService.getByName(SecurityConstants.ADMIN_NAME);
        String[] roles = admin.getAuthorities().stream().map(GrantedAuthority::getAuthority).toArray(String[]::new);
        auth.inMemoryAuthentication()
                .withUser(admin.getUsername()).password(admin.getPassword()).roles(roles);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITELIST).permitAll()
                .antMatchers("/questions/add").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/login");
        return filter;
    }

    private void saveDefaultUser() {
        if (userService.existsByName(SecurityConstants.ADMIN_NAME)) {
            return;
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        User user = new User(SecurityConstants.ADMIN_NAME, "{noop}admin", authorities);
        userService.addUser(user);
    }
}
