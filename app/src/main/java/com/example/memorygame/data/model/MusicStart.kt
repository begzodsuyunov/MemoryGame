package com.example.memorygame.data.model

import android.content.Context
import android.media.MediaPlayer
import com.example.memorygame.R

object BackMusic {

    var mediaPlayer = MediaPlayer()


    fun create(context: Context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.music)
        mediaPlayer.start()
    }

}