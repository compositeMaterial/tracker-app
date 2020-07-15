package com.killzone.simpletracker.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.killzone.simpletracker.R
import com.killzone.simpletracker.other.Constants.ACTION_PAUSE_SERVICE
import com.killzone.simpletracker.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.killzone.simpletracker.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.killzone.simpletracker.other.Constants.ACTION_STOP_SERVICE
import com.killzone.simpletracker.other.Constants.NOTIFICATION_CHANNEL_ID
import com.killzone.simpletracker.other.Constants.NOTIFICATION_CHANNEL_NAME
import com.killzone.simpletracker.other.Constants.NOTIFICATION_ID
import com.killzone.simpletracker.ui.MainActivity

class TrackingService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var isFirstRun = true

        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun) {
                        startForegroundService()
                        isFirstRun = false
                    } else {

                    }

                }
                ACTION_PAUSE_SERVICE -> {

                }
                ACTION_STOP_SERVICE -> {

                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForegroundService() {

        val notificationManager = getSystemService(
            Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(
            this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setSmallIcon(R.drawable.ic_run_24)
            .setContentTitle("Tracker App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }

}