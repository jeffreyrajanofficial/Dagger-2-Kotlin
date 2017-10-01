package com.jr.dagger2kotlinexample.dependencies.components

import com.jr.dagger2kotlinexample.MainActivity
import com.jr.dagger2kotlinexample.dependencies.modules.ApplicationModule
import com.jr.dagger2kotlinexample.dependencies.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class
))
interface ApplicationComponent {
    fun inject (mainActivity: MainActivity)
}