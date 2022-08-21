package com.azmovhudstc.pdplessonthreemusicplayer.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.azmovhudstc.pdplessonthreemusicplayer.R
import com.azmovhudstc.pdplessonthreemusicplayer.model.Music
import com.azmovhudstc.pdplessonthreemusicplayer.utils.MusicSwipeAndDrop
import kotlinx.android.synthetic.main.item.view.*
import java.util.*
import kotlin.collections.ArrayList


class MusicAdapter(var list: ArrayList<Music>, var context: Context) :
    RecyclerView.Adapter<MusicAdapter.MyViewHolder>(), MusicSwipeAndDrop {

    inner class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(movie: Music, position: Int) {
            itemView.musicName.text = movie.musicName.toString()
            itemView.songerName.text = movie.musicSonger.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewMusic: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = list[position]
        holder.onBind(currentItem, position = position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {

        if (fromPosition in 1 until toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(list,i,i-1);
            }
        }
        else if (fromPosition ==0 && fromPosition<toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(list,i,i);

            }
        }
        else{
            for (i in fromPosition downTo toPosition){
                Collections.swap(list,i,i-1)
            }
        }
        notifyItemMoved(fromPosition,toPosition)
    }

    override fun removeItem(position: Int) {

        list.removeAt(position)
        notifyItemRemoved(position)

    }

}