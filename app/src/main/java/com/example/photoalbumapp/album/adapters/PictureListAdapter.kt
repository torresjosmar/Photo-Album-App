package com.example.photoalbumapp.album.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoalbumapp.picture.PictureDetailView
import com.example.photoalbumapp.R
import com.example.photoalbumapp.service.models.PictureResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album_list.view.*

class PictureListAdapter : RecyclerView.Adapter<PictureListAdapter.ViewHolder>() {
    var pictures: List<PictureResponse>  = ArrayList()
    lateinit var context: Context

    fun PictureListAdapter(data: List<PictureResponse>, context: Context){
        this.pictures = data
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pictures.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_album_list, parent, false))
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.album_title as TextView
        val icon = view.album_icon as ImageView


        fun bind(picture: PictureResponse, context: Context) {
            title.text = picture.title

            Picasso.get().load(picture.thumbnailUrl).into(icon)

            title.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, PictureDetailView::class.java)
                intent.putExtra("picture", picture)
                context.startActivity(intent)
            })

        }


    }
}