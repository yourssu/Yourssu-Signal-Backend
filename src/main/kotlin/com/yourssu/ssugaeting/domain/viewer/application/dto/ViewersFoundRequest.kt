package com.yourssu.ssugaeting.domain.viewer.application.dto

import com.yourssu.ssugaeting.domain.viewer.business.command.AllViewersFoundCommand
import jakarta.validation.constraints.NotBlank

data class ViewersFoundRequest(
    @field:NotBlank
    val secretKey: String,
) {
    fun toCommand(): AllViewersFoundCommand {
        return AllViewersFoundCommand(
            secretKey = secretKey,
        )
    }
}
