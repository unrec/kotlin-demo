package com.unrec.demo

fun String.lastChar(): Char = get(length - 1)

val String.firstChar: Char
    get() = get(0)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    val string = "Some string"
    print("Last char for $string using extension function is '${string.lastChar()}'")
    print("First char for $string using extension property is '${string.firstChar}'")
}
