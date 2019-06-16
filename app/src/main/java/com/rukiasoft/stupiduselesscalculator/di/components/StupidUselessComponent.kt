package com.rukiasoft.stupiduselesscalculator.di.components

import com.rukiasoft.stupiduselesscalculator.StupidUselessApplication
import com.rukiasoft.stupiduselesscalculator.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


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

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class), (ActivityBuilder::class), (StupidUselessBindsModule::class),
        (StupidUselessProvidesModule::class), (FragmentsProvider::class), (FragmentsProvider::class), (ViewModelModule::class)]
)
interface StupidUselessComponent : AndroidInjector<StupidUselessApplication> {

    override fun inject(stupidUselessApp: StupidUselessApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: StupidUselessApplication): Builder

        fun build(): StupidUselessComponent
    }

}