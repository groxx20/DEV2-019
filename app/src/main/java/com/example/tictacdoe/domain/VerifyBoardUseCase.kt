package com.example.tictacdoe.domain

import com.example.tictacdoe.data.BoardRepository
import com.example.tictacdoe.domain.model.BoardUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class VerifyBoardUseCase(boardRepository: BoardRepository) {

    private val uiState = MutableStateFlow(BoardUi())

    val boardUiState: Flow<BoardUi> = uiState

    fun verifyBoard() {
        uiState.tryEmit(BoardUi())
    }
}