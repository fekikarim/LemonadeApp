package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme
import com.example.lemonadeapp.ui.components.LemonadeApp
import com.example.lemonadeapp.ui.components.LemonadeStageView

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: LemonadeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LemonadeViewModel::class.java)

        setContent {
            LemonadeAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LemonadeApp()
                }
            }
        }

    }
}
