package com.renatojobal.orix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.renatojobal.orix.ui.HomeScreen
import com.renatojobal.orix.ui.theme.OrixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrixTheme {
                HomeScreen()
            }
        }
    }
}

@Preview("Default preview")
@Composable
fun DefaultPreview() {
    OrixTheme {
        HomeScreen()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}