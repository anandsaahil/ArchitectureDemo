package com.example.data.network.service

import com.example.data.entity.UserEntity
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun getUserPosts(): Observable<Response<UserEntity>>
}