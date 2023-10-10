package com.sevity.problemservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")  // 루트부터 모든 하위경로
                    .allowedOrigins("http://sevity.com:9994", "http://localhost:9994")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowCredentials(true)  // 이 부분이 중요합니다.
           }
        }
    }
}
