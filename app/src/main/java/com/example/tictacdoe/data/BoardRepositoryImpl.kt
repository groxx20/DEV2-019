package com.example.tictacdoe.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class BoardData(val board: List<List<String>> = List(3) { List(3) { "" } })

class BoardRepositoryImpl : BoardRepository {

    private val state = MutableStateFlow(BoardData())

    override val boardState: Flow<BoardData> = state

    override fun updateBoard(row: Int, column: Int, value: String) {

        // Create a new board with the updated value, otherwise the flow won't update
        val newBoard = state.value.board.mapIndexed { _, rowList ->
            rowList.mapIndexed { _, cellValue -> cellValue }.toMutableList()
        }.toMutableList()

        // update the value on the new board
        newBoard[row][column] = value

        state.tryEmit(BoardData(board = newBoard))
    }

    override fun resetBoard() {
        state.tryEmit(BoardData())
    }
}