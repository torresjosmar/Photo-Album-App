package com.example.photoalbumapp.main

import android.util.Log
import com.example.photoalbumapp.service.APIServiceImpl
import com.example.photoalbumapp.service.models.AlbumResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsModel(){
    val connectionManager = APIServiceImpl()

    fun getAlbums(presenter: AlbumsPersenter){
        connectionManager.service.getAlbums().enqueue(object : Callback<List<AlbumResponse>> {
            override fun onResponse(call: Call<List<AlbumResponse>>, response: Response<List<AlbumResponse>>) {
                if (response.code() == 200) {
                    presenter.showData(response.body())
                }
            }
            override fun onFailure(call: Call<List<AlbumResponse>>?, t: Throwable?) {
                //TODO: error in response service
                print("error in service "+t?.message)
            }
        })

    }

}