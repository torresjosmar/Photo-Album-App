package com.example.photoalbumapp.album

import com.example.photoalbumapp.main.AlbumsPersenter
import com.example.photoalbumapp.service.APIServiceImpl
import com.example.photoalbumapp.service.models.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumModel {
    val connectionManager = APIServiceImpl()

    fun getPictures(presenter: AlbumPresenter){
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