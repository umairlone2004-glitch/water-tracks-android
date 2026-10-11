package com.example.watertracks.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// A single DataStore instance for the whole process.
private val Context.dataStore by preferencesDataStore(name = "water_tracks_prefs")

/**
 * Persists the number of glasses of water logged for the day.
 * Backed by Jetpack DataStore so the value survives the app being closed.
 */
class WaterRepository(private val context: Context) {

    private val glassCountKey = intPreferencesKey("glass_count")

    /** Emits the current glass count, or 0 if nothing has been saved yet. */
    val glassCount: Flow<Int> = context.dataStore.data.map { prefs ->
        prefs[glassCountKey] ?: 0
    }

    /** Persists a new glass count. */
    suspend fun setGlassCount(count: Int) {
        context.dataStore.edit { prefs ->
            prefs[glassCountKey] = count
        }
    }
}
