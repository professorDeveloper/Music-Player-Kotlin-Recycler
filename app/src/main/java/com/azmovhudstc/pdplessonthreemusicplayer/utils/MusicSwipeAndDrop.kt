package com.azmovhudstc.pdplessonthreemusicplayer.utils

interface MusicSwipeAndDrop {
    fun  onItemMove(fromPosition:Int,toPosition:Int)
    fun  removeItem(position:Int)

}