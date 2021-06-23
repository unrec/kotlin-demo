package com.unrec.demo

data class Song(val author: String, val name: String, val year: Int)

fun main() {
    val yesterday = Song("The Beatles", "Yesterday", 1965)
    val copy = yesterday.copy()

    println("yesterday = $yesterday")
    println("copy = $copy")
    println("yesterday.hashCode() = ${yesterday.hashCode()}")
    println("copy.hashCode() = ${copy.hashCode()}")
    println("Equals? - ${yesterday == copy}")
}