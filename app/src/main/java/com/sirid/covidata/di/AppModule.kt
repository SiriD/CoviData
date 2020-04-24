package com.sirid.covidata.di

import android.app.Application
import android.content.Context
import androidx.core.util.Pools
import com.sirid.covidata.CoviDataApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

@Module
class AppModule(val app: CoviDataApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.Default

}