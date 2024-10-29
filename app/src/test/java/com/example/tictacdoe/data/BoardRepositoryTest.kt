package com.example.tictacdoe.data

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class BoardRepositoryTest {
    private lateinit var boardRepository: BoardRepository

    @Before
    fun setup() {
        boardRepository = BoardRepositoryImpl()
    }

    @Test
    fun `updateBoard should update the board state`() = runTest {
        val row = 0
        val column = 0
        val value = "X"

        boardRepository.updateBoard(row, column, value)

        val result = boardRepository.boardState.first()
        assert(result.board[0][0] == "X")
    }

    @Test
    fun `reset board should empty all the fields of the board`() = runTest {
        val row = 0
        val column = 0
        val value = "X"

        boardRepository.updateBoard(row, column, value)

        boardRepository.resetBoard()

        val result = boardRepository.boardState.first()
        assert(result.board[0][0] == "")
    }
}