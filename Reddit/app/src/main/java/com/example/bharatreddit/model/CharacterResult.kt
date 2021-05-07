package com.example.bharatreddit.model

data class CharacterResult(
    val info: CharacterPage,
    var results: List<CharacterItem>
)

data class CharacterPage(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterItem(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String
)

data class CharacterLocation(
    val name: String
)

data class CharacterOrigin(
    val name: String
)