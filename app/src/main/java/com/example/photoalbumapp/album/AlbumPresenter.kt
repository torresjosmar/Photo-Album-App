package com.example.photoalbumapp.album

class AlbumPresenter (var albumView: AlbumView, val albumModel: AlbumModel) {
    fun getData(){
        albumModel.getPictures(this)
    }
    fun showData(pictures: List<String>){
        print("list pictures")
    }
}