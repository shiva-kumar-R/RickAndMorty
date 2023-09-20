package com.example.rickandmorty.model


import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: String?
)

data class Character(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: Gender,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: NamedUrl,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: NamedUrl,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: Status,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

data class NamedUrl(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

enum class Status(private val status: String) {
    @SerializedName(value = "Alive", alternate = ["alive"])
    ALIVE("Alive"),

    @SerializedName(value = "Dead", alternate = ["dead"])
    DEAD("Dead"),

    @SerializedName(value = "unknown", alternate = ["Unknown"])
    UNKNOWN("Unknown");

    override fun toString() = status
}

enum class Gender(private val gender: String) {
    @SerializedName(value = "Female", alternate = ["female"])
    FEMALE("Female"),

    @SerializedName(value = "Male", alternate = ["male"])
    MALE("Male"),

    @SerializedName(value = "Genderless", alternate = ["genderless"])
    GENDERLESS("Genderless"),

    @SerializedName(value = "unknown", alternate = ["Unknown"])
    UNKNOWN("Unknown");

    override fun toString() = gender
}