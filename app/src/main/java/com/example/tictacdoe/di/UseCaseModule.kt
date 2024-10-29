package com.example.tictacdoe.di

import com.example.tictacdoe.domain.ResetBoardUseCase
import com.example.tictacdoe.domain.UpdateBoardUseCase
import com.example.tictacdoe.domain.VerifyBoardUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::VerifyBoardUseCase)
    singleOf(::UpdateBoardUseCase)
    singleOf(::ResetBoardUseCase)
}