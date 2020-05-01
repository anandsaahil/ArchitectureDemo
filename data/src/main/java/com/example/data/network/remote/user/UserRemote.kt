package com.example.data.network.remote.user

import com.example.data.entity.UserEntity
import io.reactivex.Observable

interface UserRemote {
    fun getUserPosts(): Observable<List<UserEntity>>
}