package com.example.calculators.di.modul

import com.example.calculators.util.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideMoshiConverter():MoshiConverterFactory{
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(moshi: MoshiConverterFactory) : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(moshi).build()

    }
}