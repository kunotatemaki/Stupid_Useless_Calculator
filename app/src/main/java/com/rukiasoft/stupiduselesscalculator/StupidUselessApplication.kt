package com.rukiasoft.stupiduselesscalculator

import android.util.Log
import com.rukiasoft.stupiduselesscalculator.di.components.ComponentFactory
import com.rukiasoft.stupiduselesscalculator.di.components.StupidUselessComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


/**
 * Copyright (C) Rukiasoft - All Rights Reserved
 *
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 *
 * Written by Roll <raulfeliz></raulfeliz>@gmail.com>, June 2019
 */

class StupidUselessApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<StupidUselessApplication> {
        val mComponent: StupidUselessComponent = ComponentFactory.component(this)
        mComponent.inject(this)
        return mComponent
    }

    override fun onCreate() {
        super.onCreate()
//        instance = this



//        Fabric.with(this, Crashlytics())
        // Initialize Logging with Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }


    }

    /** A tree which logs important information for crash reporting. (Tiber) */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

        }
    }
}
