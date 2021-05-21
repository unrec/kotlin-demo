package com.unrec.koans.introduction

val oddNumbers = (1..17 step 2).toList()
val withEven = listOf(*oddNumbers.toTypedArray(), 2)

fun main() {
    println(containsEven(listOf(1)))
    println(containsEven(oddNumbers))
    println(containsEven(withEven))
}

fun containsEven(collection: Collection<Int>): Boolean = collection.any { x: Int -> x % 2 == 0 }
