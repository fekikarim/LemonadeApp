package com.example.lemonadeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LemonadeViewModel : ViewModel() {
    private val _lemonadeState = MutableLiveData<LemonadeState>()
    val lemonadeState: LiveData<LemonadeState> get() = _lemonadeState

    private var squeezesRemaining = 0

    init {
        startOver()
    }

    fun selectLemon() {
        _lemonadeState.value = LemonadeState.Selecting
        squeezesRemaining = (2..4).random() // Random number of squeezes between 2 and 4
    }

    fun squeezeLemon() {
        if (squeezesRemaining > 0) {
            squeezesRemaining--
            if (squeezesRemaining == 0) {
                _lemonadeState.value = LemonadeState.Drinking
            } else {
                _lemonadeState.value = LemonadeState.Squeezing
            }
        }
    }

    fun drinkLemonade() {
        _lemonadeState.value = LemonadeState.Restarting
    }

    fun startOver() {
        _lemonadeState.value = LemonadeState.Selecting
        squeezesRemaining = 0
    }

    enum class LemonadeState {
        Selecting,
        Squeezing,
        Drinking,
        Restarting
    }
}