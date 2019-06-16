package com.rukiasoft.stupiduselesscalculator.di.modules

import com.rukiasoft.stupiduselesscalculator.resources.ResourcesManager
import com.rukiasoft.stupiduselesscalculator.resources.ResourcesManagerImpl
import dagger.Binds
import dagger.Module


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
abstract class StupidUselessBindsModule {


    @Binds
    abstract fun provideResourcesManager(resourcesManagerImpl: ResourcesManagerImpl): ResourcesManager

}