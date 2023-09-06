package com.oauth2.demo.login.service;

import com.oauth2.demo.user.User;
import com.oauth2.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // 스프링 빈으로 등록
@RequiredArgsConstructor // final이 붙은 필드를 인자값으로 하는 생성자를 만들어줌
public class LoginService implements UserDetailsService { // UserDetailsService를 구현한 클래스

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email)); // 이메일이 존재하지 않으면 예외 발생

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build(); // UserDetails를 구현한 User 객체 반환

    }

}
