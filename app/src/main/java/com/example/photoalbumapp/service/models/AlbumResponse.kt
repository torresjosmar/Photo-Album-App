package com.example.photoalbumapp.service.models

import com.google.gson.annotations.SerializedName

data class AlbumResponse (@SerializedName("userId") var userId:String, @SerializedName("id") var id: Number, @SerializedName("title") var title: String)