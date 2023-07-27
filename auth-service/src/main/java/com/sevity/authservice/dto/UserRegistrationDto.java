//이거랑 User.java랑 유사하게 생겼는데
//User 클래스와 UserRegistrationDto 클래스는 서로 다른 목적으로 사용됩니다.
//User 클래스는 데이터베이스의 users 테이블에 대응하는 엔티티 클래스입니다. 이 클래스는 JPA가 데이터베이스와의 상호 작용을 위해 사용하는 도메인 모델입니다.
//UserRegistrationDto 클래스는 클라이언트로부터 받은 사용자 등록 요청 데이터를 바인딩하기 위해 사용하는 DTO(Data Transfer Object)입니다. 
//이 클래스는 사용자 등록 API의 요청 본문에 담긴 데이터를 Java 객체로 변환하는 데 사용되며 이유는 다음과 같음
/*
1. 표현 계층과 영속성 계층 분리: 엔티티 클래스는 영속성 계층에서 사용되며, DTO는 표현 계층에서 사용됩니다. 이 두 계층을 분리함으로써 각 계층의 책임을 명확히 할 수 있습니다.
2. API 스펙 변경에 유연하게 대응: 클라이언트와 서버 간에 주고받는 데이터의 형태가 변경되더라도, 이에 따라 엔티티 클래스를 변경하지 않고 DTO만 변경하면 되므로 유연하게 대응할 수 있습니다.
3. 데이터 유효성 검사: DTO에서는 클라이언트로부터 받은 데이터의 유효성을 검사할 수 있습니다. 예를 들어, 사용자 등록 요청에서 비밀번호와 비밀번호 확인이 일치하는지 검사하는 것은 DTO에서 수행할 수 있습니다. */
package com.sevity.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
    public UserRegistrationDto() {
    }
    
    public UserRegistrationDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    private String username;
    private String password;
}
