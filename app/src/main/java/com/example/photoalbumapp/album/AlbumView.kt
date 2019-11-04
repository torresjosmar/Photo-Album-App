package com.example.photoalbumapp.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.photoalbumapp.R

class AlbumView : AppCompatActivity(), Album {
    lateinit var presenter : AlbumPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        var bundle :Bundle ?= intent.extras
        var albumId = bundle!!.getString("albumId")

        if(albumId != null){
            presenter = AlbumPresenter(this, AlbumModel(),albumId)
            showPictures()
        }else{
            Toast.makeText(
                this,
                "Error loading data",
                Toast.LENGTH_SHORT
            ).show()
        }




    }

    override fun showPictures() {
        presenter.getData()
    }
}
