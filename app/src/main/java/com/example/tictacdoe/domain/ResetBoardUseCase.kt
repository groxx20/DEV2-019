package com.example.tictacdoe.domain

import com.example.tictacdoe.data.BoardRepository

class ResetBoardUseCase(private val boardRepository: BoardRepository) {
    fun resetBoard() {
        boardRepository.resetBoard()
    }
}