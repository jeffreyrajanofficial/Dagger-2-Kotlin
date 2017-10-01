package com.jr.dagger2kotlinexample

import android.app.Application
import com.jr.dagger2kotlinexample.dependencies.components.ApplicationComponent
import com.jr.dagger2kotlinexample.dependencies.components.DaggerApplicationComponent
import com.jr.dagger2kotlinexample.dependencies.modules.ApplicationModule


class DaggerApplication : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}