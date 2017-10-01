package com.jr.dagger2kotlinexample.dependencies.modules

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.jr.dagger2kotlinexample.dependencies.Scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule(protected val appCompatActivity: AppCompatActivity) {

    @Provides @ActivityScope
    fun provideActivityScope(): AppCompatActivity = appCompatActivity

    @Provides @ActivityScope
    fun provideActivityContext(): Context = appCompatActivity.baseContext

}