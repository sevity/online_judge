package com.sevity.problemservice.domain

import com.sevity.problemservice.domain.Submission
import org.springframework.data.jpa.repository.JpaRepository

interface SubmissionRepository : JpaRepository<Submission, Int>
{
    fun countByProblemId(problemId: Int): Int
}