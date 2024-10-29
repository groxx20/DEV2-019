package com.example.tictacdoe.domain

import com.example.tictacdoe.domain.model.BoardStatus
import com.example.tictacdoe.domain.model.BoardUi

fun mapBoardToUi(board: List<List<String>>): BoardUi {
    val hasWinner = hasWinner(board)
    val boardStatus = when {
        hasWinner -> BoardStatus.WIN
        !hasWinner && board.flatten().none { it.isEmpty() } -> BoardStatus.DRAW
        else -> BoardStatus.PLAYING
    }
    return BoardUi(
        board = board,
        boardStatus = boardStatus
    )
}

private fun hasWinner(board: List<List<String>>): Boolean {
    for (i in 0..2) {
        //checking rows
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0].isNotEmpty()) {
            return true
        }
        //checking columns
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i].isNotEmpty()) {
            return true
        }
    }

    // checking diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0].isNotEmpty()) {
        return true
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2].isNotEmpty()) {
        return true
    }
    return false
}