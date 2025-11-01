package com.example.lemonadeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    // local UI state (replace with ViewModel-driven state later if desired)
    var state by remember { mutableStateOf(LemonadeState.TREE) }

    fun nextState() {
        state = when (state) {
            LemonadeState.TREE -> LemonadeState.SQUEEZE
            LemonadeState.SQUEEZE -> LemonadeState.DRINK
            LemonadeState.DRINK -> LemonadeState.RESTART
            LemonadeState.RESTART -> LemonadeState.TREE
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFEB3B) // bright lemon yellow
                )
            )
        },

        // sticky footer
        bottomBar = {
            // Use a Surface so elevation/shadow is consistent with Material3
            Surface(
                tonalElevation = 2.dp,
                shadowElevation = 2.dp
            ) {
                // Footer content: small divider + centered developer credit
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Divider(thickness = 0.5.dp, color = Color(0x22000000))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // Professional styling: muted caption, slight letter spacing
                        Text(
                            text = "Developed by Karim Feki",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        )
                    }
                }
            }
        },

        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        // Place the main content, respecting the top/bottom bars
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // important: avoids overlapping the bars
        ) {
            // existing content centered in the available area
            LemonadeStageView(
                stage = state,
                onClick = { nextState() }
            )
        }
    }
}
