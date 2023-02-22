package com.unrec.demo.samples

import java.time.LocalDateTime

data class Track(
    val artist: String,
    val trackName: String,
    val date: LocalDateTime,
    val rating: Short? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Track

        if (artist != other.artist) return false
        if (trackName != other.trackName) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = artist.hashCode()
        result = 31 * result + trackName.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}

val tracks = listOf(
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 30, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 35, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 35, 0)),
    Track("Metallica", "One", LocalDateTime.of(2008, 6, 25, 13, 35, 0)),
    Track("Aerosmith", "Dream On", LocalDateTime.of(2008, 6, 25, 13, 40, 0)),
    Track("Aerosmith", "Dream On", LocalDateTime.of(2008, 6, 25, 13, 40, 0)),
    Track("Aerosmith", "Dream On", LocalDateTime.of(2008, 6, 25, 13, 40, 0)),
    Track("Aerosmith", "Dream On", LocalDateTime.of(2008, 6, 25, 13, 40, 0)),
    Track("Beatles", "Yesterday", LocalDateTime.of(2008, 6, 25, 13, 43, 0)),
    Track("U2", "One", LocalDateTime.of(2008, 6, 25, 13, 45, 0)),
    Track("U2", "One", LocalDateTime.of(2008, 6, 25, 13, 45, 0)),
)

fun main() {
    val filteredWithZip = tracks.zipWithNext()
        .filter { it.first != it.second }
        .map { it.first } + tracks.last()
    println("filteredWithZip.size = ${filteredWithZip.size}")

    val removeAdjacentDuplicates = tracks.removeAdjacentDuplicates()
    println("removeAdjacent.size = ${removeAdjacentDuplicates.size}")

    println(filteredWithZip.containsAll(removeAdjacentDuplicates))
}

fun <T : Any> Iterable<T>.removeAdjacentDuplicates(): List<T> {
    var last: T? = null
    return mapNotNull {
        if (it == last) {
            null
        } else {
            last = it
            it
        }
    }
}
