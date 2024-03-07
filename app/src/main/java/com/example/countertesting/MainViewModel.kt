package com.example.countertesting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //The initial value of the LiveData is null
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun add() {
        // This variable gets the value of the current state or, if null, gets the default value from the State()
        val currentState = state.value ?: State()
        // This variable is adding 1 to the current value of count (or the value of LiveData or the default value of the state, which is zero)
        val newCount = currentState.count + 1
        // Emitting a new state to the LiveData.
        _state.value = State(count = newCount, negative = newCount < 0)
    }

    fun sub() {
        val currentState = state.value ?: State()
        val newCount = currentState.count - 1
        _state.value = State(count = newCount, negative = newCount < 0)
    }


    data class State(
        val count: Int = 0,
        val negative: Boolean = false
    )
}
