/*

package com.sevity.problemservice.graphql

import com.expediagroup.graphql.server.operations.Query
import com.sevity.problemservice.domain.SubmissionRepository
import org.springframework.stereotype.Component

@Component
class SubmissionQueryResolver(private val submissionRepository: SubmissionRepository) : Query {
    // 응답형식 정의

    fun problemSubmissionCount(problemId: Int): ProblemSubmissionCount {
        val submissionCount = submissionRepository.countByProblemId(problemId)
        return ProblemSubmissionCount(problemId, submissionCount)
    }

}
data class ProblemSubmissionCount(val problemId: Int, val submissionCount: Int)


*/
