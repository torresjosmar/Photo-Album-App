package com.example.photoalbumapp.service.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureResponse (@SerializedName("albumId") var albumId:String, @SerializedName("id") var id: Number, @SerializedName("title") var title: String,  @SerializedName("url") var url: String, @SerializedName("thumbnailUrl") var thumbnailUrl : String) :  Parcelable {}