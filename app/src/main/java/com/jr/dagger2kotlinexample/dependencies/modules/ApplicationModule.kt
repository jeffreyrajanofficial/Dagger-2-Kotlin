package com.jr.dagger2kotlinexample.dependencies.modules

import android.content.Context
import com.jr.dagger2kotlinexample.DaggerApplication
import com.jr.dagger2kotlinexample.dependencies.qualifier.ApplicationQualifier
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: DaggerApplication) {

    @Provides @Singleton
    fun provideApplication(): DaggerApplication = app

    @Provides @Singleton
    fun provideApplicationContext(): Context = app

    @Provides @Singleton
    fun providePicasso(@ApplicationQualifier context: Context): Picasso = Picasso.Builder(context).build()

}
