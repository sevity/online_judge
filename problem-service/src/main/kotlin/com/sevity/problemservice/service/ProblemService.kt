package com.sevity.problemservice.service

import com.sevity.problemservice.domain.Problem
import com.sevity.problemservice.domain.ProblemRepository
import org.springframework.stereotype.Service

@Service
class ProblemService(private val problemRepository: ProblemRepository) {

    fun getAllProblems(): List<Problem> = problemRepository.findAll()

    // Add more methods as needed for CRUD operations
}
