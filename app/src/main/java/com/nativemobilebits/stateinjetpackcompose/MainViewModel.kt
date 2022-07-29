package com.nativemobilebits.stateinjetpackcompose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    val textFieldState = MutableLiveData("")

    fun textFieldValueUpdated(newValue:String){
        textFieldState.value = newValue
    }

}