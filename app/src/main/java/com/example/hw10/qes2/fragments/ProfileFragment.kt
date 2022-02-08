package com.example.hw10.qes2.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.hw10.R

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(),
            R.id.fragment_ProfileConatiner
        )
    }
    override fun onResume() {
        super.onResume()

        val sp =  requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        if (sp.contains("email")){
            navController.navigate(R.id.infoProfileFragment)
        }else{
            navController.navigate(R.id.registerProfileFragment)
        }
    }
}