package com.example.bharatreddit.di

import android.app.Application
import com.example.bharatreddit.di.component.CharacterComponent
import com.example.bharatreddit.di.component.DaggerCharacterComponent
import com.example.bharatreddit.di.modules.CharacterProviderModule
import com.example.bharatreddit.di.modules.RepositoryModule

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerCharacterComponent.builder()
            .characterProviderModule(CharacterProviderModule())
            .repositoryModule(RepositoryModule())
            .build()
    }

    companion object{
        lateinit var component: CharacterComponent
    }
}