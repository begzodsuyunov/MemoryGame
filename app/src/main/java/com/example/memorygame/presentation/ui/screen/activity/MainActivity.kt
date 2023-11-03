package com.example.memorygame.presentation.ui.screen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.memorygame.R
import com.example.memorygame.data.model.BackMusic
import com.example.memorygame.data.shp.MySharedPreference
import com.example.memorygame.presentation.navigator.NavigationHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler
    private val shp = MySharedPreference.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navigationHandler.navigationStack
            .onEach {
                it.invoke(fragment.findNavController())
            }
            .launchIn(lifecycleScope)
    }

    override fun onStart() {
        super.onStart()
        if (shp.music) {
            BackMusic.create(this)
            BackMusic.mediaPlayer.isLooping = true
        } else {
            BackMusic.mediaPlayer.pause()
        }
    }

    override fun onPause() {
        super.onPause()
        BackMusic.mediaPlayer.pause()
    }
}