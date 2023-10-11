package com.sevity.problemservice.controller

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import net.devh.boot.grpc.client.inject.GrpcClient

import com.sevity.authservice.grpc.SesseionServiceGrpc
import com.sevity.authservice.grpc.SessionService.SessionRequest
import com.sevity.authservice.grpc.SessionService.UserResponse
import java.lang.reflect.InvocationTargetException

@RestController
class SubmissionController {

    @GrpcClient("authService")
    private lateinit var sessionServiceStub: SesseionServiceGrpc.SesseionServiceBlockingStub

    @PostMapping("/submit")
    fun submitCode(request: HttpServletRequest): ResponseEntity<String> {
        val cookies = request.cookies
        val sessionId = cookies?.find { it.name == "SESSION" }?.value
            ?: return ResponseEntity("Session ID not found", HttpStatus.UNAUTHORIZED)

        val request2 = SessionRequest.newBuilder().setSessionId(sessionId).build()
        try {
            val response = sessionServiceStub.getUserId(request2)
            println("Received user ID: ${response.userId}")
            return ResponseEntity("Code submitted", HttpStatus.OK)
        } catch (e: InvocationTargetException) {
            e.targetException.printStackTrace()
        }

        // 나머지 로직
        return ResponseEntity("Code submitted", HttpStatus.OK)
    }
}
