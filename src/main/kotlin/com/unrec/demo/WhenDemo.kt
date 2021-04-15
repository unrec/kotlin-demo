package com.unrec.demo

fun main() {
    val number = 42
    when {
        number % 2 == 1 -> println("odd")
        number % 2 == 0 -> println("even")
        number > 0 -> println("positive")
    }
}