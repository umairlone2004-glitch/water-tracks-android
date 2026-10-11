package com.example.watertracks.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.watertracks.data.WaterRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Holds the water-tracking state and exposes the actions the UI can trigger.
 */
class WaterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WaterRepository(application)

    /** Current number of glasses logged today, backed by persistence. */
    val glassCount: StateFlow<Int> = repository.glassCount
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0
        )

    /** Logs one more glass. */
    fun addGlass() {
        viewModelScope.launch {
            repository.setGlassCount(glassCount.value + 1)
        }
    }

    /** Clears the counter back to zero. */
    fun reset() {
        viewModelScope.launch {
            repository.setGlassCount(0)
        }
    }

    companion object {
        /** The daily target, in glasses. */
        const val DAILY_GOAL = 8
    }
}
