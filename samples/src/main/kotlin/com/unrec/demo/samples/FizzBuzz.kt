package com.unrec.demo.samples

fun main(args: Array<String>) {
    for (value in 1..105) {
        when {
            value % 15 == 0 -> println("fizz buzz: $value")
            value % 3 == 0 -> println("fizz: $value")
            value % 5 == 0 -> println("buzz: $value")
        }
    }
}
