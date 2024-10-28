package com.example.tictacdoe.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class BoardRepositoryImpl : BoardRepository {

    private val state = MutableStateFlow(MutableList(3) { MutableList(3) { "" } })

    override val boardState: Flow<List<List<String>>> = state

    override fun updateBoard(row: Int, column: Int, value: String) {
        // TODO: implement logic to update board state
    }

    override fun resetBoard() {
        // TODO: implement logic to reset board state
    }
}