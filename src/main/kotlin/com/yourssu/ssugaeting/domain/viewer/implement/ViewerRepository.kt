package com.yourssu.ssugaeting.domain.viewer.implement

import com.yourssu.ssugaeting.domain.common.implement.Uuid
import com.yourssu.ssugaeting.domain.viewer.implement.domain.Viewer

interface ViewerRepository {
    fun save(viewer: Viewer): Viewer
    fun existsByUuid(uuid: Uuid): Boolean
    fun getByUuid(uuid: Uuid): Viewer
    fun updateTicket(viewer: Viewer): Viewer
    fun updateUsedTicket(viewer: Viewer): Viewer
    fun findAll(): List<Viewer>
}
