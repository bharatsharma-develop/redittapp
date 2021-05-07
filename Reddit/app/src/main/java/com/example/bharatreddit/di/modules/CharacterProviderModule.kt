package com.example.bharatreddit.di.modules

import com.example.bharatreddit.model.Repository
import com.example.bharatreddit.viewmodel.CharacterViewModel
import dagger.Module
import dagger.Provides

@Module
class CharacterProviderModule {
    @Provides
    fun provideCharacterProviderModule(repository: Repository) =
        CharacterViewModel.CharacterProvider(repository)
}