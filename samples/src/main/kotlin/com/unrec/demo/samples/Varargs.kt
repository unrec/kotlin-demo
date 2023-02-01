package com.unrec.demo.samples

val array = arrayOf("Java", "Kotlin", "Groovy")

fun main() {
    println("Type of array: ${array.javaClass}")
    println("Print as array: ${array.asList()}")

    // use of spread operator '*' to unpack the array
    val list = listOf(*array)
    println("Print as list: ${list.joinToString(separator = "; ", prefix = "(", postfix = ")")}")
}
