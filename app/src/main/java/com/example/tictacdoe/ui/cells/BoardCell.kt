package com.example.tictacdoe.ui.cells

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tictacdoe.ui.theme.Typography
import com.example.tictacdoe.ui.theme.boardCellSize
import com.example.tictacdoe.ui.theme.smallBorder
import com.example.tictacdoe.util.Constants

@Composable
fun BoardCell(isClickable: Boolean, value: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(boardCellSize)
            .border(smallBorder, Color.Black)
            .clickable(enabled = isClickable) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            style = Typography.titleLarge.copy(color = if (value == Constants.X) Color.Red else Color.Blue)
        )
    }
}