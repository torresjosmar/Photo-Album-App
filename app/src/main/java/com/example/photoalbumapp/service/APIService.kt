package com.example.photoalbumapp.service

import com.example.photoalbumapp.service.models.AlbumResponse
import com.example.photoalbumapp.service.models.PictureResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET("albums")
    fun getAlbums(): Call<List<AlbumResponse>>

    @GET
    fun getPictureByAlbum(@Url url:String): Call<List<PictureResponse>>
}