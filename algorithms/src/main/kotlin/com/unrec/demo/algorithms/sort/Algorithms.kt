package com.unrec.demo.algorithms.sort

import kotlin.random.Random

typealias SortAlgorithm = (IntArray) -> Unit

object Algorithms {

    val selectionSort: SortAlgorithm = { array ->
        for (startIndex in array.indices) {
            var minIndex = startIndex
            for (i in startIndex + 1 until array.size) {
                if (array[i] < array[minIndex]) {
                    minIndex = i
                }
            }
            if (minIndex != startIndex) {
                val tmp = array[startIndex]
                array[startIndex] = array[minIndex]
                array[minIndex] = tmp
            }
        }
    }

    val insertionSort: SortAlgorithm = { array ->
        for (i in 1 until array.size) {
            val current = array[i]
            var j = i - 1
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
    }

    val bubbleSort: SortAlgorithm = { array ->
        var sorted = false
        var temp: Int

        while (!sorted) {
            sorted = true
            for (i in 0 until array.size - 1) {
                if (array[i] > array[i + 1]) {
                    temp = array[i]
                    array[i] = array[i + 1]
                    array[i + 1] = temp
                    sorted = false
                }
            }
        }
    }
}

fun generateArray(size: Int, bound: Int) = IntArray(size) { Random.nextInt(bound) }
