package com.killzone.simpletracker.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracker_table")
data class Tracker(
    var img: Bitmap? = null,
    var timestamp: Long = 0L,
    var averageSpeed: Float = 0f,
    var distance: Int = 0,
    var timeInMilli: Long = 0L,
    var callories: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

