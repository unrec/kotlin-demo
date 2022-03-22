package com.unrec.koans.builders

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

val s = buildString {
    append("Numbers: ")
    for (i in 1..3) {
        append(i)
    }
}

fun <K,V> buildMutableMap(function: HashMap<K, V>.() -> Unit): Map<K, V> {
    val map = HashMap<K, V>()
    map.function()
    return map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun main() {
    println("s = $s")

    val map = usage()
    println("map = $map")
}