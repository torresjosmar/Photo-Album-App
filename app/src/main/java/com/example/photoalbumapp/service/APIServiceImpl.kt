package com.example.photoalbumapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIServiceImpl {
    var retrofit: Retrofit
    var service: APIService

    constructor() {
        retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIService::class.java)
    }

    companion object {
        var BaseUrl = "https://jsonplaceholder.typicode.com/"
    }
}