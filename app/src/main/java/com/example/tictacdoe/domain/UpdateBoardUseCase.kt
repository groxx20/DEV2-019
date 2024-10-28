package com.example.tictacdoe.domain

import com.example.tictacdoe.data.BoardRepository

class UpdateBoardUseCase(private val boardRepository: BoardRepository) {
    fun updateBoard(row: Int, column: Int, value: String) {
        boardRepository.updateBoard(row, column, value)
    }
}