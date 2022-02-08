package com.example.hw10.qes1.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizDataHolder:ViewModel() {

    val counterState: MutableLiveData<Int> by lazy { MutableLiveData<Int>(0) }
    init {
        counterState.value = 0

    }
    private var q1 = Pair<String, Boolean>(
        "1.Vitamin C is also known by the chemical name of Ascorbic Acid",
        true
    )
    private var q2 = Pair("2.The Pan American Highway in the U.S.A. is the world’s longest highway", true)
    private var q3 = Pair("3.Transylvania is a historical region located in central Romania", true)
    private var q4 = Pair("4.Glass is manufactured mainly from processed sand", true)
    private var q5 = Pair("5.Real Madrid football club’s biggest rival is Atlético Madrid", false)
    private var q6 = Pair(
        "6.There is no way of telling boiled eggs from raw eggs until you break them open",
        false
    )
    private var q7 =
        Pair("7.Dan Brown’s novel ‘Inferno’ was inspired by Dante Alighieri’s poem ‘Inferno’", true)
    private var q8 = Pair(
        "8.Manchester United football club has never won the UEFA Champions League trophy",
        false
    )
    private var q9 = Pair("9.Rio de Janeiro is the capital city of Brazil", false)
    private var q10 =
        Pair("10.A person’s fingernails and hair continue to grow after they die", false)
    private var qeustions = mutableListOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)

    private var qeustionsCheat =
        booleanArrayOf(false, false, false, false, false, false, false, false, false, false)

    fun getQeustionChate(): Boolean {
        return (qeustionsCheat[counterState.value!!] )
    }
    fun getQeustionText(): String {
        return qeustions[counterState.value!!].first
    }
    fun getQeustionAnswer(): Boolean  {
        return qeustions[counterState.value!!].second
    }
    fun setQeustionChateTrue() {
       qeustionsCheat[counterState.value!!] = true
    }

}