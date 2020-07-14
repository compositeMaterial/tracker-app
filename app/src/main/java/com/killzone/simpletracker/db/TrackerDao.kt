package com.killzone.simpletracker.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: Tracker)

    @Delete
    suspend fun delete(data: Tracker)

    @Query("SELECT * FROM tracker_table ORDER BY timestamp DESC")
    fun getAllDataSortedByDate(): LiveData<List<Tracker>>

    @Query("SELECT * FROM tracker_table ORDER BY timeInMilli DESC")
    fun getAllDataSortedByTimeInMilli(): LiveData<List<Tracker>>

    @Query("SELECT * FROM tracker_table ORDER BY callories DESC")
    fun getAllDataSortedByCallories(): LiveData<List<Tracker>>

    @Query("SELECT * FROM tracker_table ORDER BY averageSpeed DESC")
    fun getAllDataSortedBySpeed(): LiveData<List<Tracker>>

    @Query("SELECT * FROM tracker_table ORDER BY distance DESC")
    fun getAllDataSortedByDistance(): LiveData<List<Tracker>>

    @Query("SELECT SUM(timeInMilli) FROM tracker_table")
    fun getTotalTimeInMilli(): LiveData<Long>

    @Query("SELECT SUM(callories) FROM tracker_table")
    fun getTotalCallories(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM tracker_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT SUM(averageSpeed) FROM tracker_table")
    fun getTotalAverageSpeed(): LiveData<Float>


}