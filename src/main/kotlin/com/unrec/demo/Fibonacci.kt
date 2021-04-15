package com.unrec.demo

fun main(args: Array<String>) {
    val amount = 10
    println("$amount Fibonacci numbers using sequence: " + fibonacciSequence().take(amount).toList())
    println("$amount Fibonacci number using recursion: " + fibonacciRecursive(amount.toLong()))
}

fun fibonacciSequence(): Sequence<Long> {
    return generateSequence(1L to 1L) { it.second to it.first + it.second }.map { it.first }
}

fun fibonacciRecursive(n: Long): Long {
    return if (n < 2) n else (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2))
}