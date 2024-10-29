package com.example.tictacdoe.ui.cells

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tictacdoe.presentation.BoardViewModel
import com.example.tictacdoe.util.Constants
import org.koin.androidx.compose.koinViewModel


@Composable
fun Board(viewModel: BoardViewModel = koinViewModel(), modifier: Modifier) {

    val currentPlayer = remember {
        mutableStateOf("X")
    }

    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        uiState.board.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                row.forEachIndexed { columnIndex, cellValue ->
                    Cell(
                        value = cellValue,
                        onClick = {
                            viewModel.updateBoard(
                                rowIndex,
                                columnIndex,
                                currentPlayer.value
                            )
                            currentPlayer.value =
                                if (currentPlayer.value == Constants.O) Constants.O else Constants.X
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Cell(value: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(1.dp, Color.Black)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
//            style =
        )
    }
}