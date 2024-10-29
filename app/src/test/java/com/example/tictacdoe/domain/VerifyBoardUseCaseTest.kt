package com.example.tictacdoe.domain

import com.example.tictacdoe.data.BoardData
import com.example.tictacdoe.data.BoardRepository
import com.example.tictacdoe.domain.model.BoardStatus
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class VerifyBoardUseCaseTest {

    private lateinit var verifyBoardUseCase: VerifyBoardUseCase

    @Mock
    private lateinit var boardRepository: BoardRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        verifyBoardUseCase = VerifyBoardUseCase(boardRepository)
    }


    @Test
    fun `verify that game has a winner`() = runTest {
        val boardState = BoardData(
            board = mutableListOf(
                mutableListOf("X", "X", "X"),
                mutableListOf("O", "", "O"),
                mutableListOf("X", "", "X")
            )
        )

        `when`(boardRepository.boardState).thenReturn(flowOf(boardState))
        verifyBoardUseCase.verifyBoard()

        val result = verifyBoardUseCase.boardUiState.first()

        assert(result.boardStatus == BoardStatus.WIN)
    }

    @Test
    fun `verify that game is a draw`() = runTest {
        val boardState = BoardData(
            mutableListOf(
                mutableListOf("X", "O", "X"),
                mutableListOf("O", "X", "O"),
                mutableListOf("O", "X", "O")
            )
        )

        `when`(boardRepository.boardState).thenReturn(flowOf(boardState))
        verifyBoardUseCase.verifyBoard()

        val result = verifyBoardUseCase.boardUiState.first()

        assert(result.boardStatus == BoardStatus.DRAW)
    }
}