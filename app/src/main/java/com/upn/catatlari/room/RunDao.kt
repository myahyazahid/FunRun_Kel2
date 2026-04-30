package com.upn.catatlari.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.upn.catatlari.model.Run

@Dao
interface RunDao {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    // READ - otomatis update UI saat data berubah
    @Query("SELECT * FROM run_table ORDER BY id DESC")
    fun getAllRuns(): LiveData<List<Run>>

    // UPDATE
    @Update
    suspend fun updateRun(run: Run)

    // DELETE
    @Delete
    suspend fun deleteRun(run: Run)
}