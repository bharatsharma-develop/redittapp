package com.example.bharatreddit.model

import com.example.bharatreddit.model.network.CharacterApi

class Repository {
    private val network = CharacterApi.networkApi()

    suspend fun getNextPage(page: Int) = network.getCharacters(page)
}