package com.murimovies.data.remote

import com.murimovies.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {

    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    // Create an OkHttpClient with an interceptor to add the Bearer token
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN_HERE")
                .build()
            chain.proceed(request)
        }
        .build()

    operator fun invoke(): MovieAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonFactory)
            .client(okHttpClient)
            .build()
            .create(MovieAPIService::class.java)
    }
}
