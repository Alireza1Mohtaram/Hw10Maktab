package com.example.hw10.qes2.fragments

import android.content.Context.MODE_PRIVATE
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.hw10.R
import com.example.hw10.databinding.DataFragmentLayoutBinding


class DataFragment1 : Fragment(R.layout.data_fragment_layout) {


    private lateinit var editTextPersonFullName: EditText
    lateinit var editTextUsername: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextPhoneNumber: EditText

    lateinit var editTextRetypePassword: EditText

    lateinit var radioBtnFemale: RadioButton
    lateinit var radioBtnMale: RadioButton

    lateinit var btnRegister: Button

    lateinit var profileImage: Bitmap

    lateinit var binding: DataFragmentLayoutBinding
    lateinit var registerPic: ActivityResultLauncher<Void>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataFragmentLayoutBinding.bind(view)
        initViews()
        getRegister()
        btnRegister.setOnClickListener {
            if (validateInputs()) {
                if (storeData()) {
//                    parentFragmentManager.commit {
//                        replace<InfoFragment>(R.id.fragment_ProfileConatiner,)
//                        addToBackStack("Info")
//                        setReorderingAllowed(true)
//                    }

                    parentFragmentManager.popBackStack()
                }
            }
        }
        binding.profilePhoto.setOnClickListener {
            registerPic.launch(null)
        }
    }

    private fun getRegister() {
        registerPic = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {

            notify("Image ${it.width} * ${it.height}")
            binding.profilePhoto.setImageBitmap(it)
        }
    }


    override fun onResume() {
        super.onResume()

    }

    private fun storeData(): Boolean {
        val storeDataPreferences = requireContext().getSharedPreferences("User", MODE_PRIVATE)
        val editor = storeDataPreferences.edit().apply {
            putString("fullName", binding.editTextPersonFullName.text.toString())
            putString("username", binding.editTextUsername.text.toString())
            putString("email", binding.editTextEmail.text.toString())
            putString("password", binding.editTextPassword.text.toString())
            putString("gender", getChecked())
            putString("phone", binding.editTextPhoneNumber.text.toString())
        }

        return editor.commit()
    }

    //  find radio checked
    private fun getChecked(): String {
        if (radioBtnMale.isChecked) return radioBtnMale.text.toString()
        return radioBtnFemale.text.toString()

    }

    //check EditText is blank or not
    private fun EditText.validEditText(): Boolean {
        if (this.text.isBlank()) {
            this.error = "Empty"
            println("${this.text} = true ")
            return false
        }
        return true
    }

    //validate one by one editTexts
    private fun validateInputs(): Boolean {
        var r: Boolean = true
        r = editTextPersonFullName.validEditText() &&
                editTextUsername.validEditText() &&
                editTextEmail.validEditText() &&
                editTextPassword.validEditText() &&
                editTextRetypePassword.validEditText()

        if (editTextRetypePassword.text.toString() != editTextPassword.text.toString()) {
            notify("Password and Re-typed Password not same")
            r = false
        }
        return r
    }

    private fun notify(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {

        // init Edittext

        editTextPersonFullName = binding.editTextPersonFullName
        editTextUsername = binding.editTextUsername
        editTextEmail = binding.editTextEmail
        editTextPassword = binding.editTextPassword
        editTextRetypePassword = binding.editTextRetypePassword
        editTextPhoneNumber = binding.editTextPhoneNumber


        // init radios
        radioBtnFemale = binding.radioBtnFemale
        radioBtnMale = binding.radioBtnMale

        //init Buttons
        btnRegister = binding.btnRegister


    }

}