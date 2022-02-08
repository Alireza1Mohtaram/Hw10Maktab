package com.example.hw9

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hw10.R
import com.example.hw10.databinding.CheatFragmentBinding
import com.example.hw10.qes1.models.QuizDataHolder

class CheatFragment : Fragment(R.layout.cheat_fragment) {

    lateinit var binding: CheatFragmentBinding

    val dataHolder: QuizDataHolder by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CheatFragmentBinding.bind(view)

        binding.btnChaetAnswer.setOnClickListener {
             dataHolder.setQeustionChateTrue()
            binding.tvAnswer.text = dataHolder.getQeustionAnswer().toString()
        }

    }
}
