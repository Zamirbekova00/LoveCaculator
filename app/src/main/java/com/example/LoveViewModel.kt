package com.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.remote.LoveModel
import com.example.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun liveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}