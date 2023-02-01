package com.unrec.demo.samples

val states = listOf("California", "New York", "Texas", "Idaho", "Ohio")
val numbersList: List<Int> = (2..20 step 2).toList()
val numbersArray: IntArray = (3..33 step 3).toList().toIntArray()

fun main() {
    // print with index
    for ((index, element) in states.withIndex()) {
        println("$index: $element")
    }

    // print different collections
    println(states)
    println(numbersList)
    println(numbersArray.contentToString())
}
