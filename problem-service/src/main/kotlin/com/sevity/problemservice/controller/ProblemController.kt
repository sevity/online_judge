package com.sevity.problemservice.controller

import com.sevity.problemservice.service.ProblemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/problems")
class ProblemController(private val problemService: ProblemService) {

    @GetMapping
    fun getAllProblems() = problemService.getAllProblems()

    // Add more methods as needed for CRUD operations
}
