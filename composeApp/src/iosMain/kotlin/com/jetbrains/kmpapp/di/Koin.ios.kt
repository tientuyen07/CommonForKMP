package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.custom.localization.Localization
import org.koin.core.module.Module
import org.koin.dsl.module

actual val localizationModule: Module = module {
    single<Localization> { Localization() }
}