package com.example.tictacdoe.presentation

import com.example.tictacdoe.domain.ResetBoardUseCase
import com.example.tictacdoe.domain.UpdateBoardUseCase
import com.example.tictacdoe.domain.VerifyBoardUseCase
import com.example.tictacdoe.domain.model.BoardStatus
import com.example.tictacdoe.domain.model.BoardUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class BoardViewModelTest {

    @Mock
    private lateinit var verifyUseCase: VerifyBoardUseCase

    @Mock
    private lateinit var updateBoardUseCase: UpdateBoardUseCase

    @Mock
    private lateinit var resetBoardUseCase: ResetBoardUseCase

    private lateinit var viewModel: BoardViewModel

    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify that view model gets board state from use case`() = runTest {
        val boardUi = BoardUi(
            board = listOf(
                listOf("X", "O", "X"),
                listOf("O", "X", "O"),
                listOf("X", "O", "X")
            ),
            boardStatus = BoardStatus.WIN
        )

        `when`(verifyUseCase.boardUiState).thenReturn(flowOf(boardUi))

        viewModel = BoardViewModel(verifyUseCase, updateBoardUseCase, resetBoardUseCase)

        testDispatcher.scheduler.advanceUntilIdle()

        val result = viewModel.uiState.first()

        assert(result.boardStatus == BoardStatus.WIN)
    }
}