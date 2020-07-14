package com.killzone.simpletracker.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.killzone.simpletracker.R
import com.killzone.simpletracker.ui.viewmodels.StaticticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private val viewModel: StaticticsViewModel by viewModels()


}