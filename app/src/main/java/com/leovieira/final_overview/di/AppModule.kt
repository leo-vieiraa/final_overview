package com.leovieira.final_overview.di

import android.content.Context
import com.leovieira.final_overview.work.NotificationHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNotificationHandler(@ApplicationContext context: Context): NotificationHandler =
        NotificationHandler(context)

}