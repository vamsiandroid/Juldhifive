package com.vamsi.digitalmindstask

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor.Level

object RetrofitInstance {

    val apiServerURL = "https://api.covid19india.org/v2/";
    val retrofitClient: Retrofit.Builder by lazy {
        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)
        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)


        Retrofit.Builder()
            .baseUrl(apiServerURL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }
    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }

}
