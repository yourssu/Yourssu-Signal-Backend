package com.yourssu.ssugaeting.domain.profile.storage

import com.querydsl.jpa.impl.JPAQueryFactory
import com.yourssu.ssugaeting.domain.common.implement.Uuid
import com.yourssu.ssugaeting.domain.profile.implement.ProfileRepository
import com.yourssu.ssugaeting.domain.profile.implement.domain.Profile
import com.yourssu.ssugaeting.domain.profile.storage.domain.ProfileEntity
import com.yourssu.ssugaeting.domain.profile.storage.domain.QProfileEntity.profileEntity
import com.yourssu.ssugaeting.domain.profile.storage.execption.ProfileNotFoundException
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository

@Repository
class ProfileRepositoryImpl(
    private val profileJpaRepository: ProfileJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory,
) : ProfileRepository {
    override fun save(profile: Profile): Profile {
        val saveProfile = profileJpaRepository.save(ProfileEntity.from(profile))
        return saveProfile.toDomain(introSentences = profile.introSentences)
    }

    override fun getByUuid(uuid: Uuid): Profile {
        return jpaQueryFactory.selectFrom(profileEntity)
            .where(profileEntity.uuid.eq(uuid.value))
            .fetchFirst()
            ?.toDomain()
            ?: throw ProfileNotFoundException()
    }

    override fun getById(id: Long): Profile {
        return profileJpaRepository.findById(id)
            .orElseThrow { ProfileNotFoundException() }
            .toDomain()
    }

    override fun existsByUuid(uuid: Uuid): Boolean {
        return jpaQueryFactory.selectFrom(profileEntity)
            .where(profileEntity.uuid.eq(uuid.value))
            .fetchFirst() != null
    }

    override fun findAll(): List<Profile> {
        return profileJpaRepository.findAll().map { it.toDomain() }
    }

    @Cacheable(cacheNames = ["profileCache"])
    override fun findAllIds(): List<Long> {
        return jpaQueryFactory.select(profileEntity.id)
            .from(profileEntity)
            .fetch()
    }

    @Async
    @CachePut(cacheNames = ["profileCache"])
    override fun updateCacheProfiles(): List<Long> {
        return jpaQueryFactory.select(profileEntity.id)
            .from(profileEntity)
            .fetch()
    }
}

interface ProfileJpaRepository: JpaRepository<ProfileEntity, Long> {
}
