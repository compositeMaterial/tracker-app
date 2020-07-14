package com.killzone.simpletracker.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import com.killzone.simpletracker.repository.MainRepository

class StaticticsViewModel @ViewModelInject constructor(
    val repository: MainRepository
) {

}