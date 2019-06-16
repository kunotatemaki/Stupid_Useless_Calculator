package com.rukiasoft.stupiduselesscalculator.di.components

import com.rukiasoft.stupiduselesscalculator.StupidUselessApplication


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

object ComponentFactory {

    fun component(context: StupidUselessApplication): StupidUselessComponent {
        return DaggerStupidUselessComponent.builder()
                .application(context)
                .build()
    }

}