package com.example.photoalbumapp.service

import com.example.photoalbumapp.service.models.AlbumResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("albums")
    fun getAlbums(): Call<List<AlbumResponse>>
}