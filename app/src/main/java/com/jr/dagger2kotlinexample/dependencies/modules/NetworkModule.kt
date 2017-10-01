package com.jr.dagger2kotlinexample.dependencies.modules

import android.content.Context
import com.jr.dagger2kotlinexample.ApiService
import com.jr.dagger2kotlinexample.BuildConfig
import com.jr.dagger2kotlinexample.R
import com.jr.dagger2kotlinexample.dependencies.qualifier.ApplicationQualifier
import com.jr.dagger2kotlinexample.dependencies.qualifier.CacheDurationQualifier
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton
    fun provideCache(@ApplicationQualifier context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides @Singleton @CacheDurationQualifier
    fun provideCacheDuration(@ApplicationQualifier context: Context) = context.resources.getInteger(R.integer.cache_duration)

    @Provides @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient
        = OkHttpClient().newBuilder()
            .cache(cache)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }).build()

    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("BASE_URL")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}