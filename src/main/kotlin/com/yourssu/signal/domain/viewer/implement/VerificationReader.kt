package com.yourssu.signal.domain.viewer.implement

import com.yourssu.signal.domain.verification.implement.VerificationRepository
import com.yourssu.signal.domain.verification.implement.domain.Verification
import com.yourssu.signal.domain.verification.implement.domain.VerificationCode
import org.springframework.stereotype.Component

@Component
class VerificationReader(
    private val verificationRepository: VerificationRepository,
) {
    fun findByCode(code: VerificationCode): Verification {
        return verificationRepository.getByCode(code)
    }

    fun existsByCode(code: VerificationCode): Boolean {
        return verificationRepository.existsByCode(code)
    }
}
