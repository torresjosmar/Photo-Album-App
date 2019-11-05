package com.example.photoalbumapp.ui.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photoalbumapp.R

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
