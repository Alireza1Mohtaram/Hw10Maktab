package com.example.hw10.qes2.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hw10.R
import com.example.hw10.databinding.InfoFragmentLayoutBinding

class InfoProfileFragment : Fragment(R.layout.info_fragment_layout) {


    private lateinit var tvFullnameResult: TextView
    private lateinit var tvUsernameResult: TextView
    private lateinit var tvPasswordResult: TextView
    private lateinit var tvUEmailResult: TextView
    private lateinit var tvPhoneNumber: TextView
    private lateinit var tvGenderResult: TextView
    lateinit var infoGroup: androidx.constraintlayout.widget.Group
    lateinit var binding: InfoFragmentLayoutBinding

    private lateinit var sp :SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = InfoFragmentLayoutBinding.bind(view)
        initViews()

    }
    override fun onResume() {
        super.onResume()
        setValues()
    }
    private fun initViews() {

            binding.let{
                infoGroup = it.infoGroup
                tvFullnameResult = it.tvFullnameResult
                tvUsernameResult =it.tvUsernameResult
                tvPasswordResult =it.tvPasswordResult
                tvUEmailResult = it.tvUEmailResult
                tvGenderResult = it.tvGenderResult
                tvPhoneNumber =it.tvPhone
            }

    }
    private fun setValues() {
        requireContext().getSharedPreferences("User", MODE_PRIVATE).apply {
            tvFullnameResult.text = getString("fullName", "Full name")
            tvUsernameResult.text = getString("username", "Username")
            tvUEmailResult.text = getString("email", "Email")
            tvPasswordResult.text = getString("password", "Password")
            tvGenderResult.text = getString("gender", "Gender")
            tvPhoneNumber.text = getString("phone", "phone")

        }
    }

}