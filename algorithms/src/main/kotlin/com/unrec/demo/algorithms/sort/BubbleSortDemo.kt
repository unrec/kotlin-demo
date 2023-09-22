package com.unrec.demo.algorithms.sort

fun main() {
    val bubbleSort = Algorithms.bubbleSort
    val array = generateArray(size = 10, bound = 100)
    println("Initial array = ${array.contentToString()}")

    bubbleSort(array)
    println("Sorted array = ${array.contentToString()}")
}
