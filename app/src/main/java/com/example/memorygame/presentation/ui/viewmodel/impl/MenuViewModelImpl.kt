package com.example.memorygame.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorygame.domain.usecase.MenuUseCase
import com.example.memorygame.presentation.navigator.Navigator
import com.example.memorygame.presentation.ui.screen.fragment.main.MenuFragmentDirections
import com.example.memorygame.presentation.ui.viewmodel.MenuViewModel
import com.example.memorygame.utils.eventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModelImpl @Inject constructor(
    private val useCase: MenuUseCase,
    private val navigator: Navigator
): MenuViewModel, ViewModel() {


    override val levelFlow = eventFlow<String>()

    init {
        viewModelScope.launch {
            useCase.getLevel().collectLatest {
                levelFlow.emit(it)
            }
        }
    }

    override fun onClickPlay(level: String) {
        viewModelScope.launch {
            navigator.navigateTo(MenuFragmentDirections.actionMenuFragmentToMiniLevelFragment(level))
        }
    }

    override suspend fun setLevel(level: String) = useCase.setLevel(level)

    override fun onClickNext(level: String) {
        viewModelScope.launch {
            when (level) {
                "4x4\neasy" -> {
                    levelFlow.emit(
                        "6x6\n" +
                                "medium"
                    )
                }
                "6x6\nmedium" -> {
                    levelFlow.emit(
                        "6x8\n" +
                                "hard"
                    )
                }
                "6x8\nhard" -> {
                    levelFlow.emit(
                        "4x4\n" +
                                "easy"
                    )
                }
            }
        }
    }

    override fun onClickPrev(level: String) {
        viewModelScope.launch {
            viewModelScope.launch {
                when (level) {
                    "4x4\neasy" -> {
                        levelFlow.emit(
                            "6x8\n" +
                                    "hard"
                        )
                    }
                    "6x6\nmedium" -> {
                        levelFlow.emit(
                            "4x4\n" +
                                    "easy"
                        )
                    }
                    "6x8\nhard" -> {
                        levelFlow.emit(
                            "6x6\n" +
                                    "medium"
                        )
                    }
                }
            }
        }
    }

    override fun onClickSetting() {
    }

    override fun onClickInfo() {
    }
}