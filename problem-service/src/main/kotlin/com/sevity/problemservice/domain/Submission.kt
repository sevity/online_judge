package com.sevity.problemservice.domain
import javax.persistence.*

@Entity
@Table(name = "submissions")
data class Submission(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "problem_id", nullable = false)
    val problemId: Long,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val code: String,

    @Column(nullable = false)
    val status: String
    // 다른 필요한 필드
)
