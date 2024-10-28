package com.example.tictacdoe.di

import com.example.tictacdoe.data.BoardRepository
import com.example.tictacdoe.data.BoardRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val repositoryModule = module {
    singleOf(::BoardRepositoryImpl) bind BoardRepository::class
}
