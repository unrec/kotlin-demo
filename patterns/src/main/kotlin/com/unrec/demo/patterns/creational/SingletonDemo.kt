package com.unrec.demo.patterns.creational

fun main() {
    println("Movies list = ${MoviesSingleton.getNames()}")
}

// this object will be instantiated as Singleton, it's not possible to create this object via constructor
object MoviesSingleton {

    init {
        println("Initializing MoviesSingleton...")
    }

    private val movieList: List<Movie> = movies.filter { it.year > 1999 }
    fun getNames(): List<String> = movieList.map { it.name }
}

data class Movie(
    val name: String,
    val year: Short,
    val isAdult: Boolean? = false
)

val movies = listOf(
    Movie("Pulp Fiction", 1994),
    Movie("Star Trek", 2019),
    Movie("Sin City", 2005)
)
