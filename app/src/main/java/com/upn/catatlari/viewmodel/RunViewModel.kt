package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.upn.catatlari.model.Run
import com.upn.catatlari.room.RunDatabase
import kotlinx.coroutines.launch

class RunViewModel(application: Application) : AndroidViewModel(application) {

    private val runDao = RunDatabase.getDatabase(application).runDao()

    // LiveData langsung dari Room — otomatis update UI saat data berubah
    val runHistory: LiveData<List<Run>> = runDao.getAllRuns()

    // CREATE
    fun addRun(run: Run) {
        viewModelScope.launch {
            runDao.insertRun(run)
        }
    }

    // UPDATE
    fun updateRun(run: Run) {
        viewModelScope.launch {
            runDao.updateRun(run)
        }
    }

    // DELETE
    fun deleteRun(run: Run) {
        viewModelScope.launch {
            runDao.deleteRun(run)
        }
    }
}