package com.unrec.demo.samples

val items1 = listOf(
    RatedItem(5.5f, "The Don", "John", 1984),
    RatedItem(5.6f, "The House", "Jane", 1946),
    RatedItem(7.8f, "The House", "Alice", 2002),
)

val items2 = listOf(
    RatedItem(5.5f, "The Don", "John", 1984),
    RatedItem(10.0f, "The Super Duper", "Director", 2022),
    RatedItem(7.8f, "The House", "Alice", 2002),
)

fun main() {
    val compareValuesBy = compareValuesBy(items1, items2) { it.size }
    println("compareValuesBy = $compareValuesBy")

}

