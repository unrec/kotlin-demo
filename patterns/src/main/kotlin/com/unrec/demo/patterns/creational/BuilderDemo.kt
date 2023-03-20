package com.unrec.demo.patterns.creational

fun main() {

    val popSong = SongBuilder()
        .author("The Beatles")
        .name("Yesterday")
        .album(listOf("Help!", "Greatest Hits"))
        .rating(5)
        .build()

    println("song = $popSong")

    // instead of creating Builder class itself it's easy to use named parameters with constructor
    val rockSong = SongBuilder.Song(
        author = "Aerosmith",
        name = "Dream On",
        album = listOf("Aerosmith", "Greatest Hits"),
        rating = 5
    )

    println("rockSong = $rockSong")
}

class SongBuilder {
    private var author: String = ""
    private var name: String = ""
    private var album: List<String>? = null
    private var rating: Short = 0

    data class Song internal constructor(
        val author: String,
        val name: String,
        val album: List<String>?,
        val rating: Short
    )

    fun build(): Song {
        if (author.isBlank() || name.isBlank()) {
            throw IllegalArgumentException("'Author' or 'Name' is not provided")
        }

        return Song(author, name, album, rating)
    }

    fun author(author: String): SongBuilder {
        this.author = author
        return this
    }

    fun name(name: String): SongBuilder {
        this.name = name
        return this
    }

    fun album(album: List<String>): SongBuilder {
        this.album = album
        return this
    }

    fun rating(rating: Short): SongBuilder {
        this.rating = rating
        return this
    }
}
