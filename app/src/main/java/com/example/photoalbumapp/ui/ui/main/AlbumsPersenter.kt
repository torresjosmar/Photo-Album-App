package com.example.photoalbumapp.ui.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoalbumapp.ui.ui.main.adapters.AlbumListAdapter
import com.example.photoalbumapp.service.models.AlbumResponse
import kotlinx.android.synthetic.main.activity_main.*

class AlbumsPersenter(var albumsView: AlbumsView, val albumsModel: AlbumsModel) {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter :AlbumListAdapter = AlbumListAdapter()
    fun getData(){
        albumsModel.getAlbums(this)
    }

    fun showData(albums: List<AlbumResponse>){
        //show info in view
        mRecyclerView = albumsView.albumList as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(albumsView)
        mAdapter.AlbumListAdapter(albums, albumsView)
        mRecyclerView.adapter = mAdapter
    }

}