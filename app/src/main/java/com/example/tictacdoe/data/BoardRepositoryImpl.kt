package com.example.tictacdoe.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class BoardData(val board: MutableList<MutableList<String>> = MutableList(3) { MutableList(3) { "" } })

class BoardRepositoryImpl : BoardRepository {

    private val state = MutableStateFlow(BoardData())

    override val boardState: Flow<BoardData> = state

    override fun updateBoard(row: Int, column: Int, value: String) {
        val board = state.value
        board.board[row][column] = value
        state.tryEmit(board)
    }

    override fun resetBoard() {
        state.tryEmit(BoardData())
    }
}