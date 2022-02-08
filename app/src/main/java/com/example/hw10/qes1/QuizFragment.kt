package com.example.hw9

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.hw10.R
import com.example.hw10.databinding.ActivityQuizBinding
import com.example.hw10.databinding.QuizFragmentBinding
import com.example.hw10.qes1.models.QuizDataHolder

class QuizFragment : Fragment(R.layout.quiz_fragment) {

//    private var q1 = Pair<String, Boolean>(
//        "1.Vitamin C is also known by the chemical name of Ascorbic Acid",
//        true
//    )
//    private var q2 = Pair("2.The Pan American Highway in the U.S.A. is the world’s longest highway", true)
//    private var q3 = Pair("3.Transylvania is a historical region located in central Romania", true)
//    private var q4 = Pair("4.Glass is manufactured mainly from processed sand", true)
//    private var q5 = Pair("5.Real Madrid football club’s biggest rival is Atlético Madrid", false)
//    private var q6 = Pair(
//        "6.There is no way of telling boiled eggs from raw eggs until you break them open",
//        false
//    )
//    private var q7 =
//        Pair("7.Dan Brown’s novel ‘Inferno’ was inspired by Dante Alighieri’s poem ‘Inferno’", true)
//    private var q8 = Pair(
//        "8.Manchester United football club has never won the UEFA Champions League trophy",
//        false
//    )
//    private var q9 = Pair("9.Rio de Janeiro is the capital city of Brazil", false)
//    private var q10 =
//        Pair("10.A person’s fingernails and hair continue to grow after they die", false)
//    private var qeustions = mutableListOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)
//
//    private var qeustionsCheat =
//        booleanArrayOf(false, false, false, false, false, false, false, false, false, false)

    private val dataHolder : QuizDataHolder by activityViewModels()

    lateinit var luncher: ActivityResultLauncher<Intent>
    lateinit var binding: QuizFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = QuizFragmentBinding.bind(view)

        dataHolder.counterState.observe(viewLifecycleOwner){
            binding.qesBox.text = dataHolder.getQeustionText()
        }

       // getLuncher()
        initFirst(savedInstanceState)

        binding.btnTrue.setOnClickListener {
            getCurrentAnswer(true)
        }
        binding.btnFalse.setOnClickListener {
            getCurrentAnswer(false)
        }
        binding.btnCheat.setOnClickListener {
//            val i = Intent(this@Quiz, CheatActivity::class.java)
//            i.putExtra("answer", dataHolder.getQeustionAnswer())
//            luncher.launch(i)
            it.findNavController().navigate(R.id.cheatActivity)

        }
        binding.btnNext.setOnClickListener {
            nextQes()
        }
        binding.btnPrev.setOnClickListener {
            pervQes()
        }
    }
//
//    private fun getLuncher() {
//        luncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            qeustionsCheat[conterState] = it.data?.getBooleanExtra("cheat", false) ?: false
//        }
//    }

    private fun notify(s: String) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()
    }
    private fun nextQes() {
        binding.btnPrev.isEnabled = true
        if (dataHolder.counterState.value == 8) binding.btnNext.isEnabled = false

        dataHolder.counterState.value = dataHolder.counterState.value?.plus(1)
    }

    private fun pervQes() {
        binding.btnNext.isEnabled = true

        if (dataHolder.counterState.value == 1) binding.btnPrev.isEnabled = false
        dataHolder.counterState.value = dataHolder.counterState.value?.minus(1)

    }

    private fun getCurrentAnswer(userAnswer: Boolean) {

        if (dataHolder.getQeustionAnswer() == userAnswer) {
            if (dataHolder.getQeustionChate()) {
                notify("Cheat is Wrong")
                return
            } else {
                notify("Correct!")
                return
            }
        }
        notify("InCorrect!")
        return
    }

    private fun initFirst(savedInstanceState: Bundle?) {
//
//        conterState = savedInstanceState?.getInt("conterState") ?: 0
//        qeustionsCheat = savedInstanceState?.getBooleanArray("cheatArray") ?: qeustionsCheat
        binding.qesBox.text = dataHolder.getQeustionText()

        if (dataHolder.counterState.value == 0) {
            binding.btnPrev.isEnabled = false
        } else if (dataHolder.counterState.value == 9) {
            binding.btnNext.isEnabled = false
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putInt("conterState", conterState)
//        outState.putBooleanArray("cheatArray", qeustionsCheat)
//        super.onSaveInstanceState(outState)
//    }


}