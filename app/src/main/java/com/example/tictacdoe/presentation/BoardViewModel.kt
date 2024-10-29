package com.example.tictacdoe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictacdoe.domain.ResetBoardUseCase
import com.example.tictacdoe.domain.UpdateBoardUseCase
import com.example.tictacdoe.domain.VerifyBoardUseCase
import com.example.tictacdoe.domain.model.BoardUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoardViewModel(
    verifyBoardUseCase: VerifyBoardUseCase,
    private val updateBoardUseCase: UpdateBoardUseCase,
    private val resetBoardUseCase: ResetBoardUseCase
) : ViewModel() {
    private val state = MutableStateFlow(BoardUi())
    val uiState: StateFlow<BoardUi> = state

    init {
        viewModelScope.launch {
            verifyBoardUseCase.boardUiState.collect { boardUi ->
                state.value = boardUi
            }
        }
    }

    fun updateBoard(row: Int, column: Int, value: String) {
        updateBoardUseCase.updateBoard(row, column, value)
    }

    fun resetBoard() {
        resetBoardUseCase.resetBoard()
    }

}