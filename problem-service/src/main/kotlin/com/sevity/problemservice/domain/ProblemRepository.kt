package com.sevity.problemservice.domain

import com.sevity.problemservice.domain.Problem
import org.springframework.data.jpa.repository.JpaRepository

interface ProblemRepository : JpaRepository<Problem, Int>