package com.unrec.demo

data class Album(val artist: String, val name: String, val year: Int) {
    companion object Informer {
        fun mainData(album: Album) = "${album.artist} - ${album.name} (${album.year})"
    }

    fun newMethod() = "new method from class"
}

fun Album.newMethodExtension() = "new method from extension"
fun Album.Informer.newMethod() = "new method from companion"

fun main() {
    val album = Album("Metallica", "Black Album", 1991)

    println(Album.mainData(album))
    println(Album.newMethod())
    println(album.newMethod())
    println(album.newMethodExtension())
}
