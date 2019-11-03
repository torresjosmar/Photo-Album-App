package com.example.photoalbumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.photoalbumapp.service.APIServiceImpl
import com.example.photoalbumapp.service.models.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val connectionManager = APIServiceImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAlbumsInfo()
    }

    private fun getAlbumsInfo(){

        connectionManager.service.getAlbums().enqueue(object : Callback<List<AlbumResponse>> {
            override fun onResponse(call: Call<List<AlbumResponse>>, response: Response<List<AlbumResponse>>) {
                if (response.code() == 200) {
                    Log.d("JOSMAR", "servicio ok")
                    Log.d("JOSMAR",response.body().toString())
                    //TODO: service response data in responde.body
                }
            }
            override fun onFailure(call: Call<List<AlbumResponse>>?, t: Throwable?) {
                //TODO: error in response service
                print("error in service "+t?.message)
                Log.d("JOSMAR", "error en servicio")
            }
        })

    }
}
