package com.example.data.repository

import com.example.data.dataSource.user.UserDataSourceFactory
import com.example.data.entity.mapper.UserDataMapper
import com.example.domain.model.UserDomain
import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository @Inject constructor(
    private val userDataSourceFactory: UserDataSourceFactory,
    private val userDataMapper: UserDataMapper
) : UserRepository {
    override fun getUserPosts(): Observable<UserDomain> {
        return userDataSourceFactory.retrieveRemoteDataSource().getUserPosts()
            .map {
                return@map userDataMapper.mapEntityToDomain(it)
            }
    }
}