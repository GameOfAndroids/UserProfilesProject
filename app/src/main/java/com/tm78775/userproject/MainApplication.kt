package com.tm78775.userproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    // initializing the application here.
    // required for Hilt dependency injection.
}