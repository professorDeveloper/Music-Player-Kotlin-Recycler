package com.azmovhudstc.pdplessonthreemusicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azmovhudstc.pdplessonthreemusicplayer.adapter.MusicAdapter
import com.azmovhudstc.pdplessonthreemusicplayer.model.Music
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        musicAdapter = MusicAdapter(loadDate(), applicationContext.applicationContext)
        rv_music.layoutManager = LinearLayoutManager(this)
        rv_music.adapter = musicAdapter
        var itemTouch = object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                var dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                var swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(
                    dragFlags, swipeFlags
                )
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                musicAdapter.onItemMove(viewHolder.adapterPosition,target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                musicAdapter.removeItem(viewHolder.adapterPosition)
            }

        }
        val itemTouchHelper=ItemTouchHelper(itemTouch)
        itemTouchHelper.attachToRecyclerView(rv_music)
    }

    private fun loadDate(): ArrayList<Music> {
        list = ArrayList()
        list.add(Music("Bones", "Image Dragons"))
        list.add(Music("La vida", "Indila"))
        list.add(Music("Ego", "Willy William"))
        list.add(Music("Enemy ", "Image Dragons"))
        list.add(Music("Unstoppable ", "Sia"))
        list.add(Music("QishYaqin", "M1nor"))
        list.add(Music("Mentalitet", "M1nor"))
        list.add(Music("Maktub", "M1nor"))
        list.add(Music("Industry Baby", "Katy Perry"))
        list.add(Music("Despacito", "Luis Fonsi"))
        list.add(Music("Beliver", "Image Dragons"))
        list.add(Music("Bad lair", "Image Dragons"))
        list.add(Music("Fairytale", "Alexander Rybak"))
        list.add(Music("Brat", "M1nor"))
        return list
    }
}