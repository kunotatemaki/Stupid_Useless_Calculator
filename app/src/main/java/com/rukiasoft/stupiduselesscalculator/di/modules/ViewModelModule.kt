package com.rukiasoft.stupiduselesscalculator.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rukiasoft.stupiduselesscalculator.di.interfaces.ViewModelKey
import com.rukiasoft.stupiduselesscalculator.ui.main.MainViewModel
import com.rukiasoft.stupiduselesscalculator.viewmodel.StupidUselessViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Copyright (C) Rukiasoft - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Roll <raulfeliz@gmail.com>, septiembre 2018
 *
 *
 */

@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: StupidUselessViewModelFactory): ViewModelProvider.Factory
}