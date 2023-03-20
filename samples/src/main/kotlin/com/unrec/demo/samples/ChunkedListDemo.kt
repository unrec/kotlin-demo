package com.unrec.demo.samples

val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

fun main() {
    val chunked = list.chunked(2)
    println("chunked = $chunked")
}
