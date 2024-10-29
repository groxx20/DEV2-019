package com.example.tictacdoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tictacdoe.ui.cells.Board
import com.example.tictacdoe.ui.theme.TicTacDoeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacDoeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Board(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}