package com.example.photoalbumapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.photoalbumapp.R
import com.example.photoalbumapp.service.APIServiceImpl
import com.example.photoalbumapp.service.models.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsView : AppCompatActivity(), Albums {


    val persenter = AlbumsPersenter(this, AlbumsModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAlbums()
    }

    override fun showAlbums(){
        persenter.getData()
    }
}
