package com.example.countertesting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //aqui o valor inicial do liveData é null
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun add(){
        // essa variavel pega o valor do estado atual ou caso seja nullo pega o valor default do State()
        val currentState = state.value ?: State()
        // essa variavel esta somando 1 no valor atual do count (ou valor do LiveDAte ou valor default do estado que é zero)
        val newCount = currentState.count +1
        // emitindo um novo estado para o liveData
        _state.value = State(count = newCount, negative =  newCount < 0)
    }

    fun sub(){
        val currentState = state.value ?: State()
        val newCount = currentState.count -1
        _state.value = State(count = newCount, negative =  newCount < 0)
    }


    data class State(
        val count: Int = 0,
        val negative: Boolean = false
    )
}
