package com.example.tictacdoe.domain

import com.example.tictacdoe.data.BoardRepository
import com.example.tictacdoe.domain.model.BoardUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class VerifyBoardUseCase(private val boardRepository: BoardRepository) {

    private val uiState = MutableStateFlow(BoardUi())

    val boardUiState: Flow<BoardUi> = uiState

    suspend fun verifyBoard() {
        boardRepository.boardState.map {
            mapBoardToUi(it.board)
        }.collect {
            uiState.tryEmit(it)
        }
    }
}