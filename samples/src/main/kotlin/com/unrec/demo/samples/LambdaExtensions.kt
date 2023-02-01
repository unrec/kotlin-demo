package com.unrec.demo.samples

private val isDividedByThreeSum: Int.(Int, Int, Int) -> Boolean = { arg1, arg2, arg3 -> this % (arg1 + arg2 + arg3) == 0 }

private val duplicate: String.(Int) -> String = { repeat(it) }
private fun String.transform(n: Int, lambda: String.(Int) -> String) = lambda(this, n)

fun main() {
    val isDivided = 42.isDividedByThreeSum(3, 36, 3)
    println("isDivided = $isDivided")

    val transformed = "abc".transform(3, duplicate)
    println("transformed = $transformed")
}
