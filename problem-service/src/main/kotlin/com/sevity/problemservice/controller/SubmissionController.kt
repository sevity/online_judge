package com.sevity.problemservice.controller

import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import net.devh.boot.grpc.client.inject.GrpcClient

import com.sevity.authservice.grpc.SesseionServiceGrpc
import com.sevity.authservice.grpc.SessionService.SessionRequest
import org.springframework.web.bind.annotation.RequestBody
import com.sevity.problemservice.service.SubmissionService


@RestController
class SubmissionController(private val submissionService: SubmissionService) {

    @GrpcClient("authService")
    private lateinit var sessionServiceStub: SesseionServiceGrpc.SesseionServiceBlockingStub

    data class SubmissionRequest(
        val problemId: Long,
        val sourceCode: String
    )

    @PostMapping("/submit")
    fun submitCode(
        @RequestBody requestBody: SubmissionRequest,
        request: HttpServletRequest
    ): ResponseEntity<String> {
        val cookies = request.cookies
        val sessionId = cookies?.find { it.name == "SESSION" }?.value
            ?: return ResponseEntity("Session ID not found", HttpStatus.UNAUTHORIZED)

        val grpcRequest = SessionRequest.newBuilder().setSessionId(sessionId).build()
        val userId: Long
        try {
            val response = sessionServiceStub.getUserId(grpcRequest)
            userId = response.userId.toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity("An error occurred: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }

        val problemId = requestBody.problemId
        val sourceCode = requestBody.sourceCode

        submissionService.submitProblem(userId, problemId, sourceCode)
        return ResponseEntity("Code submitted", HttpStatus.OK)
    }
}
