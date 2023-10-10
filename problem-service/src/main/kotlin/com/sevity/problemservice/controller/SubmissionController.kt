package com.sevity.problemservice.controller

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SubmissionController {

    @PostMapping("/submit")
    fun submitCode(request: HttpServletRequest): ResponseEntity<String> {
        val cookies = request.cookies
        val sessionId = cookies?.find { it.name == "SESSION" }?.value

        if (sessionId == null) {
            return ResponseEntity("Session ID not found", HttpStatus.UNAUTHORIZED)
        }

        // 나머지 로직
        return ResponseEntity("Code submitted", HttpStatus.OK)
    }
}
