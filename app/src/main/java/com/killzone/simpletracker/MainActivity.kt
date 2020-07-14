package com.killzone.simpletracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.killzone.simpletracker.db.TrackerDao
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dao: TrackerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView.setText("RUNDAO: ${dao.hashCode()}")

    }

}