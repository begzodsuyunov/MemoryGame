package com.example.memorygame.presentation.ui.screen.fragment.main

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygame.R
import com.example.memorygame.data.model.BackMusic
import com.example.memorygame.data.shp.MySharedPreference
import com.example.memorygame.databinding.DialogInfoBinding
import com.example.memorygame.databinding.DialogSettingBinding
import com.example.memorygame.databinding.FragmentMenuBinding
import com.example.memorygame.presentation.ui.viewmodel.MenuViewModel
import com.example.memorygame.presentation.ui.viewmodel.impl.MenuViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()
    private lateinit var level: String
    private val shp = MySharedPreference.getInstance()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.levelFlow.collectLatest {
                level = it
                binding.level.text = it
            }
        }

        binding.next.setOnClickListener {
            viewModel.onClickNext(level)
        }
        binding.prev.setOnClickListener {
            viewModel.onClickPrev(level)
        }

        binding.play.setOnClickListener {
            viewModel.onClickPlay(level)
        }

        binding.settings.setOnClickListener {
            settingDialog()
        }
        binding.info.setOnClickListener {
            showInfoDialog()
        }
    }


    private fun settingDialog() {

        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogBinding =
            DialogSettingBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding.musicSwitch.isChecked = BackMusic.mediaPlayer.isPlaying
        dialogBinding.musicSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                BackMusic.create(requireContext())
                BackMusic.mediaPlayer.isLooping = true
                shp.music = true
            } else {
                shp.music = false
                BackMusic.mediaPlayer.pause()
            }
        }
        dialogBinding.musicSwitch.isChecked = shp.music

        dialogBinding.soundSwitch.isChecked = shp.vibration
        dialogBinding.soundSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            shp.vibration = isChecked
        }
        dialogBinding.soundSwitch.isChecked = shp.vibration

        dialogBinding.lang.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setView(dialogBinding.root)
        dialog.show()
    }

    private fun showInfoDialog() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogBinding =
            DialogInfoBinding.inflate(LayoutInflater.from(requireContext()), null, false)

        dialog.setCancelable(false)

        dialog.window!!.setBackgroundDrawable(
            ColorDrawable(
                Color.TRANSPARENT
            )
        )

        dialogBinding.yes.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setView(dialogBinding.root)
        dialog.show()
    }

}