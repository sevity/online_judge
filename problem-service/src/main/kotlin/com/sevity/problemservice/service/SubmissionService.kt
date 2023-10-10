package com.sevity.problemservice.service

import com.sevity.problemservice.domain.Submission
import com.sevity.problemservice.domain.SubmissionRepository
import org.springframework.stereotype.Service

@Service
class SubmissionService(private val submissionRepository: SubmissionRepository) {

    fun submitProblem(userId: Long, problemId: Long, code: String): Submission {
        val submission = Submission(
            userId = userId,
            problemId = problemId,
            code = code,
            status = "PENDING" // 초기 상태
        )
        return submissionRepository.save(submission)
    }

    // 다른 필요한 메서드
}
