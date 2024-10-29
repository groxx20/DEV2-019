package com.example.tictacdoe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictacdoe.domain.ResetBoardUseCase
import com.example.tictacdoe.domain.UpdateBoardUseCase
import com.example.tictacdoe.domain.VerifyBoardUseCase
import com.example.tictacdoe.domain.model.BoardUi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BoardViewModel(
    private val verifyBoardUseCase: VerifyBoardUseCase,
    private val updateBoardUseCase: UpdateBoardUseCase,
    private val resetBoardUseCase: ResetBoardUseCase
) : ViewModel() {

    val uiState: StateFlow<BoardUi> = verifyBoardUseCase.boardUiState.map { it }
        .stateIn(viewModelScope, SharingStarted.Eagerly, BoardUi())

    init {
        viewModelScope.launch {
            verifyBoardUseCase.verifyBoard()
        }
    }

    fun updateBoard(row: Int, column: Int, value: String) {
        viewModelScope.launch {
            updateBoardUseCase.updateBoard(row, column, value)
        }
    }

    fun resetBoard() {
        viewModelScope.launch {
            resetBoardUseCase.resetBoard()
        }
    }

}