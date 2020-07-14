package com.killzone.simpletracker.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.killzone.simpletracker.repository.MainRepository

// No need to ViewModel Factory (automatic). No need function to provide
// MainRepository - Dagger implicitly know how to create MainRepository
// cause it know how to create DAO object.

class MainViewModel @ViewModelInject constructor(
    val repository: MainRepository
) {
}