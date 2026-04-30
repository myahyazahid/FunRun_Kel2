package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RunViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RunViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RunViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}