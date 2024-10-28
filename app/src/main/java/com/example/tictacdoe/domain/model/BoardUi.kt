package com.example.tictacdoe.domain.model

data class BoardUi(
    val board: List<List<String>> = List(3) { List(3) { "" } },
    val boardStatus: BoardStatus = BoardStatus.GAME
)


