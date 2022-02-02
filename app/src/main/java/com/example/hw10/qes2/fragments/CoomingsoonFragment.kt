package com.example.hw10.qes2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw10.R
import com.example.hw10.databinding.CoomingsoonFragmentLayoutBinding

class CoomingsoonFragment : Fragment(R.layout.coomingsoon_fragment_layout) {


    lateinit var binding: CoomingsoonFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CoomingsoonFragmentLayoutBinding.bind(view)
        binding.btnShare1.setOnClickListener {

            sendMovie(
                binding.titleSoonFragment1.text.toString(),
                binding.descSoonFragment1.text.toString()
            )
        }

        binding.btnShare2.setOnClickListener {
            sendMovie(
                binding.titleSoonFragment2.text.toString(),
                binding.descSoonFragment2.text.toString()
            )
        }

        binding.btnShare3.setOnClickListener {
            sendMovie(
                binding.titleSoonFragment3.text.toString(),
                binding.descSoonFragment3.text.toString()
            )
        }
    }
    private fun sendMovie(title: String, desc: String) {

        val i = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$title \n $desc")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(i,"movie"))
    }
}