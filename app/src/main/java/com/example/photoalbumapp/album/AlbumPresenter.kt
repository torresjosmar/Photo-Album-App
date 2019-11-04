package com.example.photoalbumapp.album

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoalbumapp.album.adapters.PictureListAdapter
import com.example.photoalbumapp.service.models.AlbumResponse
import com.example.photoalbumapp.service.models.PictureResponse
import kotlinx.android.synthetic.main.activity_album.*

class AlbumPresenter (var albumView: AlbumView, val albumModel: AlbumModel, val idAlbum: String) {
    lateinit var mRecyclerView : RecyclerView
    val mAdapter :PictureListAdapter = PictureListAdapter()
    fun getData(){
        albumModel.getPictures(this,idAlbum)
    }
    fun showData(pictures: List<PictureResponse>){
        mRecyclerView = albumView.pictureList as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(albumView)
        mAdapter.PictureListAdapter(pictures, albumView)
        mRecyclerView.adapter = mAdapter
    }
}