package team.appjam.tigris_server.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import team.appjam.tigris_server.global.error.ExceptionFilter;
import team.appjam.tigris_server.global.security.jwt.JwtTokenFilter;
import team.appjam.tigris_server.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity security) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        ExceptionFilter exceptionFilter = new ExceptionFilter();

        security.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        security.addFilterBefore(exceptionFilter, JwtTokenFilter.class);
    }

}
