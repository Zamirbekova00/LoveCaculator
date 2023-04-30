package com.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.remote.LoveModel

class LoveViewModel : ViewModel() {
    private val repository = Repository()

    fun liveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}