package com.example.tictacdoe.ui.cells

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tictacdoe.R
import com.example.tictacdoe.domain.model.BoardStatus
import com.example.tictacdoe.presentation.BoardViewModel
import com.example.tictacdoe.ui.theme.Typography
import com.example.tictacdoe.ui.theme.spacingLarge
import com.example.tictacdoe.ui.theme.spacingRegular
import com.example.tictacdoe.util.Constants
import org.koin.androidx.compose.koinViewModel


@Composable
fun Board(viewModel: BoardViewModel = koinViewModel(), modifier: Modifier) {

    val currentPlayer = remember { mutableStateOf(Constants.X) }

    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "${stringResource(id = R.string.turn)} ${currentPlayer.value}",
            style = Typography.titleLarge,
            modifier = Modifier.padding(spacingLarge)
        )

        uiState.board.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                row.forEachIndexed { columnIndex, cellValue ->
                    BoardCell(
                        isClickable = uiState.boardStatus == BoardStatus.PLAYING && cellValue.isEmpty(),
                        value = cellValue,
                        onClick = {
                            viewModel.updateBoard(
                                rowIndex,
                                columnIndex,
                                currentPlayer.value
                            )
                            currentPlayer.value =
                                if (currentPlayer.value == Constants.O) Constants.X else Constants.O
                        }
                    )
                }
            }
        }

        when (uiState.boardStatus) {
            BoardStatus.WIN, BoardStatus.DRAW -> {
                StatusCell(uiState.boardStatus)
                Button(
                    modifier = Modifier.padding(spacingRegular),
                    onClick = { viewModel.resetBoard() }) {
                    Text(text = stringResource(id = R.string.reset))
                }
            }

            else -> {}
        }


    }
}

