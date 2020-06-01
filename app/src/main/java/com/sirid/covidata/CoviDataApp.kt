package com.sirid.covidata

import android.app.Application
import android.content.Context

class CoviDataApp: Application() {
    companion object {
        private var instance: CoviDataApp? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}