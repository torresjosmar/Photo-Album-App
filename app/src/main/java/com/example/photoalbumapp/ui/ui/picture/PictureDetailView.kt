package com.example.photoalbumapp.ui.ui.picture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.photoalbumapp.R
import com.example.photoalbumapp.service.models.PictureResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture_detail_view.*

class PictureDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detail_view)


        var bundle :Bundle ?= intent.extras
        var picture = bundle!!.getParcelable<PictureResponse>("picture")

        if(picture != null){
            initView(picture)
        }else{
            Toast.makeText(
                this,
                "Error loading data",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun initView(picture: PictureResponse){
        Picasso.get().load(picture.url).into(picture_image)
        picture_title.text = "Title: "+picture.title
    }
}
