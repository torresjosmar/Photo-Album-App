package com.example.photoalbumapp.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.photoalbumapp.R

class Album : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        var bundle :Bundle ?= intent.extras
        var albumId = bundle!!.getString("albumId")



        Toast.makeText(
            this,
            "id de album "+albumId,
            Toast.LENGTH_SHORT
        ).show()
    }
}
