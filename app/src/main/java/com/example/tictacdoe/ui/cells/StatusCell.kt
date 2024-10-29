package com.example.tictacdoe.ui.cells

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tictacdoe.domain.model.BoardStatus
import com.example.tictacdoe.ui.theme.Typography
import com.example.tictacdoe.ui.theme.spacingLarge

@Composable
fun StatusCell(status: BoardStatus) {
    Text(
        modifier = Modifier.padding(spacingLarge),
        text = status.name,
        style = Typography.titleLarge.copy(color = if (status == BoardStatus.WIN) Color.Green else Color.Blue)
    )
}