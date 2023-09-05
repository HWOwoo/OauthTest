package com.oauth2.demo.jwt.filter;

import com.oauth2.demo.jwt.service.JwtService;
import com.oauth2.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationProcessingFilter extends OncePerRequestFilter {

    private static final String NO_CHECK_URL = "/login"; // 로그인은 토큰 검사를 하지 않는다.

    private final JwtService jwtService;
    private final UserRepository userRepository;

    private

}
