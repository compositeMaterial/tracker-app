package com.killzone.simpletracker.repository

import com.killzone.simpletracker.db.Tracker
import com.killzone.simpletracker.db.TrackerDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val dao: TrackerDao
) {

    suspend fun insertTrackerData(data: Tracker) = dao.insert(data)
    suspend fun deleteTrackerData(data: Tracker) = dao.delete(data)

    fun getAllDataSortedByData() = dao.getAllDataSortedByDate()
    fun getAllDataSortedByDistance() = dao.getAllDataSortedByDistance()
    fun getAllDataSortedByMillis() = dao.getAllDataSortedByTimeInMilli()
    fun getAllDataSortedByCallories() = dao.getAllDataSortedByCallories()
    fun getAllDataSortedBySpeed() = dao.getAllDataSortedBySpeed()

    fun getTotalAverageSpeed() = dao.getTotalAverageSpeed()
    fun getTotalCallories() = dao.getTotalCallories()
    fun getTotalDistance() = dao.getTotalDistance()
    fun getTotalTime() = dao.getTotalTimeInMilli()

}