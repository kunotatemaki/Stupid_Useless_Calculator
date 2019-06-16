package com.rukiasoft.stupiduselesscalculator.di.modules

import com.rukiasoft.stupiduselesscalculator.di.interfaces.CustomScopes
import com.rukiasoft.stupiduselesscalculator.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


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
abstract class FragmentsProvider {

    @CustomScopes.FragmentScope
    @ContributesAndroidInjector
    abstract fun providesMainFragmentFactory(): MainFragment

}