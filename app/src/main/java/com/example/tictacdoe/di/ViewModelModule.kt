package com.example.tictacdoe.di

import com.example.tictacdoe.presentation.BoardViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::BoardViewModel)
}