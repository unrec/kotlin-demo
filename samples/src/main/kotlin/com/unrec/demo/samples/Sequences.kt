package com.unrec.demo.samples

val naturalNumbers = generateSequence(0) { it + 1 }
val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }.toList()

fun main() {
    println("numbersTo100 = $numbersTo100")
}
