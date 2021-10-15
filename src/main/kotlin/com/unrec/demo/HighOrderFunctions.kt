package com.unrec.demo

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

fun operator(func: (Int, Int) -> Int, a: Int, b: Int): Int {
    return func(a, b)
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

var predicate: (Char) -> Boolean = { ch: Char -> ch in 'a'..'z' }

fun main() {
    val sumUp = operator(sum, 40, 66)
    println(sumUp)

    twoAndThree { a, b -> a * b }

    val chars = arrayListOf('a', '1', 'b', '2', 'c')
    for (c in chars) {
        if (predicate(c)) {
            println(c)
        }
    }
}