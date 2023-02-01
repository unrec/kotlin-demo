package com.unrec.demo.samples

import kotlin.math.log10

fun isValidBin(value: Int?): Boolean {
    return when (value?.let { (log10(value.toDouble()) + 1).toInt() }) {
        null -> false
        6 -> true
        8 -> true
        else -> false
    }
}

fun main() {
    val number = 42
    when {
        number % 2 == 1 -> println("odd")
        number % 2 == 0 -> println("even")
        number > 0 -> println("positive")
    }
}
