package com.rukiasoft.stupiduselesscalculator.di.modules

import com.rukiasoft.stupiduselesscalculator.MainActivity
import com.rukiasoft.stupiduselesscalculator.di.interfaces.CustomScopes
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilder {

    @CustomScopes.ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity


}