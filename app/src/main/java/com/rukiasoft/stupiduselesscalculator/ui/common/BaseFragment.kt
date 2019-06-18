package com.rukiasoft.stupiduselesscalculator.ui.common

import com.rukiasoft.androidapps.cocinaconroll.preferences.PreferencesManager
import com.rukiasoft.stupiduselesscalculator.viewmodel.StupidUselessViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


/**
 * Copyright (C) Rukiasoft - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Roll <raulfeliz@gmail.com>, June 2019
 *
 *
 */

abstract class BaseFragment: DaggerFragment() {

     @Inject
     protected lateinit var viewModelFactory: StupidUselessViewModelFactory

}