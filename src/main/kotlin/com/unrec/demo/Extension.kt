package com.unrec.demo

fun String.lastChar(): Char = get(length - 1)

val String.firstChar: Char
    get() = get(0)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun String.incrementLastDigit(): String =
    this.substring(0, this.length - 1) + (Character.getNumericValue(this.lastChar()) + 1) % 10


fun main() {
    val string = "Some string"
    println("Last char for $string using extension function is '${string.lastChar()}'")
    println("First char for $string using extension property is '${string.firstChar}'")

    val number = "123"
    println("$number with incremented last digit = ${number.incrementLastDigit()}")
}
