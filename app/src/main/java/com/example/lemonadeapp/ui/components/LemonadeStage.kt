package com.example.lemonadeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.R
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

enum class LemonadeState {
    TREE, SQUEEZE, DRINK, RESTART
}

@Composable
fun LemonadeStageView(stage: LemonadeState, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // image changes with state
            val (imageRes, text) = when (stage) {
                LemonadeState.TREE -> R.drawable.lemon_tree to "Click to select a lemon"
                LemonadeState.SQUEEZE -> R.drawable.lemon_squeeze to "Click to juice the lemon"
                LemonadeState.DRINK -> R.drawable.lemon_drink to "Click to drink your lemonade"
                LemonadeState.RESTART -> R.drawable.lemon_restart to "Click to start again"
            }

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = text,
                modifier = Modifier
                    .clickable { onClick() }
                    .padding(bottom = 16.dp)
            )

            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeStageViewPreview() {
    LemonadeAppTheme {
        LemonadeStageView(stage = LemonadeState.TREE, onClick = {})
    }
}
