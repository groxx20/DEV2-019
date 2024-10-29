package com.example.tictacdoe.data

import kotlinx.coroutines.flow.Flow

interface BoardRepository {

    val boardState: Flow<BoardData>

    fun updateBoard(row: Int, column: Int, value: String)

    fun resetBoard()
}