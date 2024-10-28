package com.example.tictacdoe.data

import kotlinx.coroutines.flow.Flow

interface BoardRepository {

    val boardState: Flow<List<List<String>>>

    fun updateBoard(row: Int, column: Int, value: String)

    fun resetBoard()
}