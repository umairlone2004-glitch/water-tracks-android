package com.example.watertracks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.watertracks.ui.WaterScreen
import com.example.watertracks.ui.WaterViewModel
import com.example.watertracks.ui.theme.WaterTracksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTracksTheme {
                val viewModel: WaterViewModel = viewModel()
                WaterScreen(viewModel = viewModel)
            }
        }
    }
}
