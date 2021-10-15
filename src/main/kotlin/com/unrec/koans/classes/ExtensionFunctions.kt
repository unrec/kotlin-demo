package com.unrec.koans.classes

fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main() {
    println(42.r())
    println(Pair(10, 20).r())
}