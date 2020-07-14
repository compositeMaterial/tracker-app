package com.killzone.simpletracker.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.killzone.simpletracker.R
import com.killzone.simpletracker.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackerFragment : Fragment(R.layout.fragment_tracker) {

    private val viewModel: MainViewModel by viewModels()

}