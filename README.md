| 목표 | 체크| 내용|
| ------ | --|----------- |
| 1. |☑️|  OAuth2 이해 (블로그참고) |
| 2. |☑️|  https://nelapham.tistory.com/136?category=1161039 |
| 3. |☑️|  실제로 작동 되는지 테스트 |
| 0. | ☐|  실제 프로젝트에 적용 |

------

# Spring Boot OAuth 2.0 테스트

이 프로젝트는 Spring Boot를 사용하여 GitHub OAuth 2.0을 구현한 예시입니다.

## 설정

1. 원하는 애플리케이션 (NAVER,KAKAO,GOOGLE)를 등록하고 클라이언트 ID와 클라이언트 시크릿을 받아옵니다. GitHub의 [OAuth Apps 설정 페이지](https://github.com/settings/developers)에서 애플리케이션을 등록하세요.

2. `application.yml` 파일에서 클라이언트 ID와 클라이언트 시크릿을 설정하세요.

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: 변경할 부분
            client-secret: 변경할 부분
            scope: profile, email
          naver:
            client-id: 변경할 부분
            client-secret: 변경할 부분
            redirect-uri: 변경할 부분 (설정한 redirect URI)
            authorization-grant-type: authorization_code
            scope: name, email, profile_image
            client-name: Naver
          kakao:
            client-id: 변경할 부분
            client-secret: 변경할 부분
            redirect-uri: 변경할 부분 (설정한 redirect URI)
            client-authentication-method: POST
            authorization-grant-type: authorization_code
            scope: profile_nickname, profile_image
            client-name: Kakao
        provider:
          naver:
            authorization_uri: https://nid.naver.com/oauth2.0/authorize
            token_uri: https://nid.naver.com/oauth2.0/token
            user-info-uri: https://openapi.naver.com/v1/nid/me
            user_name_attribute: response

          kakao:
            authorization-uri: https://kauth.kakao.com/oauth/authorize
            token-uri: https://kauth.kakao.com/oauth/token
            user-info-uri: https://kapi.kakao.com/v2/user/me
            user-name-attribute: id
```

------


위의 README 파일은 프로젝트 사용자에게 다음 정보를 제공합니다.

```
1. 프로젝트 설정 방법
```


