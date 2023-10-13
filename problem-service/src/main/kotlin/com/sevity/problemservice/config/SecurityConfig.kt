/*
package com.sevity.problemservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .anyRequest().permitAll()  // 모든 요청을 허용합니다.
            .and()
            .csrf().disable()  // CSRF 보호를 비활성화합니다.
    }

    // 추가적으로 필요한 bean 및 구성을 정의할 수 있습니다.
}
*/