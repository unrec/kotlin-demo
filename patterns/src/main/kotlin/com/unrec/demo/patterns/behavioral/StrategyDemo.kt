/*
Strategy pattern defines a family of algorithms, encapsulates each one, and make them interchangeable.
Strategy lets the algorithm vary independently of the clients that use it.
 */

package com.unrec.demo.patterns.behavioral

import com.unrec.demo.algorithms.sort.Algorithms
import com.unrec.demo.algorithms.sort.Algorithms.selectionSort
import kotlin.random.Random

fun main() {
    val sorter = Sorter()
    val array = generateArray(size = 10, bound = 100)
    println("Initial array = ${array.contentToString()}")

    val copy1 = array.clone()
    sorter.sort(copy1)
    println("Sorted array = ${copy1.contentToString()}")

    // change algorithm of the Sorter
    sorter.algorithm = Algorithms.insertionSort

    val copy2 = array.clone()
    sorter.sort(copy2)
    println("Sorted array = ${copy2.contentToString()}")
}

class Sorter {

    var algorithm = selectionSort

    fun sort(array: IntArray) = algorithm.invoke(array)
}

fun generateArray(size: Int, bound: Int) = IntArray(size) { Random.nextInt(bound) }


