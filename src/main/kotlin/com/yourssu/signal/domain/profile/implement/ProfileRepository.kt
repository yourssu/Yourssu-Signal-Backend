package com.yourssu.signal.domain.profile.implement

import com.yourssu.signal.domain.common.implement.Uuid
import com.yourssu.signal.domain.profile.implement.domain.Gender
import com.yourssu.signal.domain.profile.implement.domain.Profile

interface ProfileRepository {
    fun save(profile: Profile): Profile
    fun getByUuid(uuid: Uuid): Profile
    fun existsByUuid(uuid: Uuid): Boolean
    fun findAll(): List<Profile>
    fun countContacts(contact: String): Int
    fun findIdsByGender(gender: Gender): List<Long>
    fun updateCacheIdsByGender(gender: Gender): List<Long>
    fun getById(id: Long): Profile
}
