package com.example.photoalbumapp.ui.ui.main.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoalbumapp.R
import com.example.photoalbumapp.ui.ui.album.AlbumView
import com.example.photoalbumapp.service.models.AlbumResponse
import kotlinx.android.synthetic.main.item_album_list.view.*

class AlbumListAdapter : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>(){

    var albums: List<AlbumResponse>  = ArrayList()
    lateinit var context: Context

    fun AlbumListAdapter(albums : List<AlbumResponse>, context: Context){
        this.albums = albums
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = albums.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_album_list, parent, false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.album_title as TextView
        val icon = view.album_icon as ImageView


        fun bind(album: AlbumResponse, context: Context) {
            title.text = album.title
            icon.setImageResource(R.drawable.album_icon)

            title.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, AlbumView::class.java)
                intent.putExtra("albumId", album.id.toString())
                context.startActivity(intent)
            })
        }


    }
}