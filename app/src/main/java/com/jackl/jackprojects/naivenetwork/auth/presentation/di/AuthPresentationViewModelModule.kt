package com.jackl.jackprojects.naivenetwork.auth.presentation.di

import com.jackl.jackprojects.naivenetwork.auth.presentation.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationViewModelModule = module {
    viewModelOf(::LoginViewModel)
}