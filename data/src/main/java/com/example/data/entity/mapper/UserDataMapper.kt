package com.example.data.entity.mapper

import com.example.data.entity.UserEntity
import com.example.domain.model.UserDomain
import javax.inject.Inject

// ==== Check import for User in the domain --> model ====


class UserDataMapper @Inject constructor() {

    fun mapEntityToDomain(userEntity: UserEntity): UserDomain {
        return UserDomain(
            name = userEntity.name!!,
            email = userEntity.email,
            phone = userEntity.phone
        )
    }
}