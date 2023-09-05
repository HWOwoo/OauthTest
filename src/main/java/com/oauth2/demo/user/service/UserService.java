package com.oauth2.demo.user.service;

import com.oauth2.demo.user.Role;
import com.oauth2.demo.user.User;
import com.oauth2.demo.user.dto.UserSignUpDto;
import com.oauth2.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) {

        if(userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        if(userRepository.findByNickname(userSignUpDto.getNickname()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 닉네임입니다.");
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .nickname(userSignUpDto.getNickname())
                .age(userSignUpDto.getAge())
                .city(userSignUpDto.getCity())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }
// Parameter 1 of constructor in com.oauth2.demo.user.service.UserService required a bean of type 'org.springframework.security.crypto.password.PasswordEncoder' that could not be found.
// Consider defining a bean of type 'org.springframework.security.crypto.password.PasswordEncoder' in your configuration.
    // 위 에러가 발생하는 이유는 PasswordEncoder를 Bean으로 등록하지 않았기 때문이다.
    // PasswordEncoder는 Spring Security에서 제공하는 인터페이스이다.
    // 따라서 PasswordEncoder를 구현한 BCryptPasswordEncoder를 Bean으로 등록해야 한다.
    // 이를 위해 SecurityConfig 클래스를 생성한다.

}
