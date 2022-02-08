package com.example.hw10.qes2.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import com.example.hw10.R
import com.example.hw10.databinding.RegisterFragmentLayoutBinding


class RegisterProfileFragment : Fragment(R.layout.register_fragment_layout) {


    private lateinit var editTextPersonFullName: EditText
    lateinit var editTextUsername: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextPhoneNumber: EditText

    lateinit var editTextRetypePassword: EditText

    lateinit var radioBtnFemale: RadioButton
    lateinit var radioBtnMale: RadioButton

    lateinit var btnRegister: Button

    lateinit var binding: RegisterFragmentLayoutBinding

    lateinit var observerCamera: registerCameraPic
    lateinit var observerGalleryaPic: registerGalleryaPic




    inner class registerCameraPic(val registry: ActivityResultRegistry) : DefaultLifecycleObserver {

        lateinit var registerCameraPic: ActivityResultLauncher<Void>

        override fun onCreate(owner: LifecycleOwner) {

            registerCameraPic =
                registry.register("key2", owner, ActivityResultContracts.TakePicturePreview()) {
                    if (it != null) {
                        notify("height : ${it.height} , width :${it.width} ")
                    }
                }
        }
        fun selectImageCamera() {
            registerCameraPic.launch(null)
        }
        private fun notify(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }


    inner class registerGalleryaPic(val registry: ActivityResultRegistry ) : DefaultLifecycleObserver {

        lateinit var registerGalleryaPic: ActivityResultLauncher<String>

        override fun onCreate(owner: LifecycleOwner) {
            registerGalleryaPic =
                registry.register("key", owner, ActivityResultContracts.GetContent()) {
                    notify(it.toString())
                }

        }

        fun selectImage() {
            registerGalleryaPic.launch("image/*")
        }

        fun notify(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerCamera = registerCameraPic(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observerCamera)

        observerGalleryaPic = registerGalleryaPic(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observerGalleryaPic)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RegisterFragmentLayoutBinding.bind(view)
        initViews()
        btnRegister.setOnClickListener {
            if (validateInputs()) {
                if (storeData()) {
                    it.findNavController().navigate(R.id.infoProfileFragment)
                }
            }
        }

        binding.cameraChooserFab.setOnClickListener {
            observerCamera.selectImageCamera()
        }
        binding.gelleryChooserFab.setOnClickListener {
            observerGalleryaPic.selectImage()
        }

    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == 1) {
//            if (resultCode == RESULT_OK) {
//                val uri = data?.data
//                val img = activity?.contentResolver?.openInputStream(uri as Uri)
//                val bitmap = BitmapFactory.decodeStream(img)
//                notify("ok")
//            }
//        }
//    }


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

    override fun onResume() {
        super.onResume()
    }


}