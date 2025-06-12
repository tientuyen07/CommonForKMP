package com.jetbrains.kmpapp.custom.localization

import platform.Foundation.NSUserDefaults

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Localization {
    actual fun applyLanguages(iso: String) {
        NSUserDefaults.standardUserDefaults.setObject(arrayListOf(iso), "AppleLanguages")
    }
}
