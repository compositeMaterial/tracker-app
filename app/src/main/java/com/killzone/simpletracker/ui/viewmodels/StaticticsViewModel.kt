package com.killzone.simpletracker.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.killzone.simpletracker.repository.MainRepository

class StaticticsViewModel @ViewModelInject constructor(
    val repository: MainRepository
) : ViewModel() {

}