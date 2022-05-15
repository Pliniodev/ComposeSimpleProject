package com.pliniodev.composesimpleproject.network.retrofit

import com.pliniodev.composesimpleproject.network.constants.Authorization
import com.pliniodev.composesimpleproject.network.constants.Authorization.marvelAuth
import com.pliniodev.composesimpleproject.network.constants.Authorization.marvelPublicKey
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.Calendar

internal class DogsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", Authorization.dogsAuth)
        return chain.proceed(requestBuilder.build())
    }
}

internal class NewsApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", Authorization.newsApiAuth)
        return chain.proceed(requestBuilder.build())
    }
}

internal class MarvelApiInterceptor : Interceptor {

    private companion object {

        val timestamp = Calendar.getInstance().timeInMillis / 1000
        val ts = timestamp.toString()
        val hash = "$ts$marvelAuth".md5()

        fun String.md5(): String =
            BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
                .toString(16).padStart(32, '0')
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder()
            .addQueryParameter("apikey", marvelPublicKey)
            .addQueryParameter("ts", ts)
            .addQueryParameter("hash", hash)
            .build()

        val request = originalRequest
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}
