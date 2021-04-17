package com.example.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// view model id aware of lifecycle
//x 

class DiceRollerViewModel : ViewModel() {
    private val _currentDice =  MutableLiveData<Int>()
    val currentDice : LiveData<Int>
        get() =  _currentDice
    private lateinit var DiceImageList: MutableList<Int>

    fun resetList() {
        DiceImageList = mutableListOf(1,2,3,4,5,6)
        DiceImageList.shuffle()
    }

    init {
        resetList()
    }
    fun rollDice() {

        //Select and remove a word from the list
        if (DiceImageList.isEmpty()) {
            resetList()
        }
//
        _currentDice.value = DiceImageList.removeAt(0)


    }
}