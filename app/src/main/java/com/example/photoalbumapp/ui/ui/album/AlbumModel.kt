package com.example.photoalbumapp.ui.ui.album

import com.example.photoalbumapp.service.APIServiceImpl
import com.example.photoalbumapp.service.models.PictureResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumModel {
    val connectionManager = APIServiceImpl()

    fun getPictures(presenter: AlbumPresenter, idAlbum: String){
        connectionManager.service.getPictureByAlbum("photos?albumId="+idAlbum).enqueue(object : Callback<List<PictureResponse>> {
            override fun onResponse(call: Call<List<PictureResponse>>, response: Response<List<PictureResponse>>) {
                if (response.code() == 200) {
                    presenter.showData(response.body())
                }
            }
            override fun onFailure(call: Call<List<PictureResponse>>?, t: Throwable?) {
                //TODO: error in response service
                print("error in service "+t?.message)
            }
        })

    }
}