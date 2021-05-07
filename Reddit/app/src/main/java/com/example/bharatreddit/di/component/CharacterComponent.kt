package com.example.bharatreddit.di.component

import com.example.bharatreddit.di.modules.CharacterProviderModule
import com.example.bharatreddit.di.modules.RepositoryModule
import com.example.bharatreddit.view.CharacterListFragment
import dagger.Component

@Component(modules = [CharacterProviderModule::class, RepositoryModule::class])
interface CharacterComponent {
    fun inject(fragment: CharacterListFragment)
}