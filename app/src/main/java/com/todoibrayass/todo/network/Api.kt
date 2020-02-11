package com.todoibrayass.todo.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {
    private const val BASE_URL = "https://android-tasks-api.herokuapp.com/api/"
    private const val TOKEN =  "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyMjEsImV4cCI6MTYxMzA1MDk4NH0.8I7DolLiwZIn4axD9SyTj3cmAn_bAg3tf4-EvHCWVqQ"
    private val moshi = Moshi.Builder().build()
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $TOKEN")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val userService: UserService by lazy { retrofit.create(UserService::class.java) }
}