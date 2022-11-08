package com.unrec.demo

val doubleArray = doubleArrayOf(12.0, 11.0)

fun main() {
    val stringArray = doubleArray.map { it.toString() }.toTypedArray().contentToString()
    println("stringArray = $stringArray")
}
