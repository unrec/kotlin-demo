package com.unrec.demo

import kotlin.math.log10

fun Int.digitsNumber() = (log10(this.toDouble()) + 1).toInt()

fun main() {
    val n = 100042
    val digitsNumber = n.digitsNumber()
    println("digitsNumber = $digitsNumber")
}