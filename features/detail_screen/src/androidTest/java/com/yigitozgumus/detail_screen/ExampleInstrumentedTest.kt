/*
 * Created by yigitozgumus on 4/4/22, 10:10 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:10 PM
 */

package com.yigitozgumus.detail_screen

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.yigitozgumus.detail_screen.test", appContext.packageName)
    }
}
