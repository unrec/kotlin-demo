package com.unrec.demo.patterns.creational

fun main() {
    // we create an object that will be used as our Prototype
    val sinCity = Movie("Sin City", 2005)

    // copy() method is used to create similar object with different value for specific field(s)
    val kingKong = sinCity.copy(name = "King Kong")
    println("kingKong = $kingKong")
    println("Is 'Sin City' is 'King Kong' movie? = ${sinCity == kingKong}")
}
