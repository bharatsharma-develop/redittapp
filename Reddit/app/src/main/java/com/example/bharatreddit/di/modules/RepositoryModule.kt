package com.example.bharatreddit.di.modules

import com.example.bharatreddit.model.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRepositoryModule() = Repository()
}