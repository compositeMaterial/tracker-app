package com.killzone.simpletracker.di

import android.content.Context
import androidx.room.Room
import com.killzone.simpletracker.db.TrackerDatabase
import com.killzone.simpletracker.other.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideTrackerDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app, TrackerDatabase::class.java, DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideTrackerDao(db: TrackerDatabase) = db.getDatabase()



}