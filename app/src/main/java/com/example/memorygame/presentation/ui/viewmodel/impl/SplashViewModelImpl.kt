package com.example.memorygame.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygame.presentation.navigator.Navigator
import com.example.memorygame.presentation.ui.screen.fragment.splash.SplashFragmentDirections
import com.example.memorygame.presentation.ui.viewmodel.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val navigator: Navigator
) : SplashViewModel, ViewModel() {
    override fun openMenuScreen() {
        viewModelScope.launch {
            delay(2000)
            navigator.navigateTo(SplashFragmentDirections.actionSplashFragmentToMenuFragment())
        }
    }
}