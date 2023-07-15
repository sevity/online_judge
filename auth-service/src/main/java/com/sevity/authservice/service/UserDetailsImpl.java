//UserDetails는 스프링에서 정의한 인터페이스이며 이파일은 그 구현체입니다.
//도메인 모델 클래스인 User와 UserDetails 인터페이스를 구현한 UserDetailsImpl(이파일)은 서로 다른 목적을 가지고 있습니다. 
//User는 데이터베이스의 users 테이블과 매핑되어 데이터베이스에서 사용자 정보를 조회하는 데 사용되며, 
//UserDetailsImpl은 Spring Security에서 사용자 인증 정보를 관리하는 데 사용됩니다.
//그렇다면 왜 UserDetails 인터페이스를 구현하는 클래스를 따로 만들 필요가 있을까요? 이는 Spring Security의 유연성 때문입니다. 
//Spring Security는 다양한 인증 방식과 사용자 정보 형태를 지원하기 위해 UserDetails 인터페이스를 제공합니다. 
//이를 통해 개발자는 자신의 애플리케이션에 맞는 사용자 인증 정보 형태를 자유롭게 구현할 수 있습니다.
package com.sevity.authservice.service;

import com.sevity.authservice.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
