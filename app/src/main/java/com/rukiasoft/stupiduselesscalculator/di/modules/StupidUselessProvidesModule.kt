package com.rukiasoft.stupiduselesscalculator.di.modules

import android.content.Context
import com.rukiasoft.stupiduselesscalculator.StupidUselessApplication
import dagger.Module
import dagger.Provides


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

@Module(includes = [(ViewModelModule::class)])
class StupidUselessProvidesModule {


    @Provides
    fun providesContext(application: StupidUselessApplication): Context = application.applicationContext


}