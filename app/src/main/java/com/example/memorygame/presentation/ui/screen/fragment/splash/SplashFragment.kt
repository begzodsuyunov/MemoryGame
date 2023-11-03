package com.example.memorygame.presentation.ui.screen.fragment.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygame.R
import com.example.memorygame.databinding.FragmentSplashBinding
import com.example.memorygame.presentation.ui.viewmodel.SplashViewModel
import com.example.memorygame.presentation.ui.viewmodel.impl.SplashViewModelImpl
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {


    private val binding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openMenuScreen()
        memoryAnimation(binding.memory)
        gameAnimation(binding.game)

    }

    private fun memoryAnimation(view: View) {

        val rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f)
        val transitionY =
            ObjectAnimator.ofFloat(
                view,
                "translationY",
                view.y,
                320f
            )

        AnimatorSet().apply {
            play(transitionY).with(rotation)
            duration = 2000
            start()
        }
    }


    private fun gameAnimation(view: View) {

        val rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, -360f)
        val transitionY =
            ObjectAnimator.ofFloat(
                view,
                "translationY",
                view.y,
                -320f
            )

        AnimatorSet().apply {
            play(transitionY).with(rotation)
            duration = 2000
            start()
        }
    }

}