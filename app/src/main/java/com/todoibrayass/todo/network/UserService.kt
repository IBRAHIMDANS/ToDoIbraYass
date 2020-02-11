package com.todoibrayass.todo.network

import okhttp3.Response
import retrofit2.http.GET

interface UserService {
    @GET("users/info")
    suspend fun getInfo(): Response<UserInfo>
}