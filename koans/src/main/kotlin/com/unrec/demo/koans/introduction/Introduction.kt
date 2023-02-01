package com.unrec.demo.koans.introduction

fun start(): String = "OK"

fun joinOptions(options: Collection<String>): String {
    return options.joinToString(prefix = "[", postfix = "]")
}

fun foo(
    name: String,
    number: Int = 42,
    toUpperCase: Boolean = false
) = (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)
