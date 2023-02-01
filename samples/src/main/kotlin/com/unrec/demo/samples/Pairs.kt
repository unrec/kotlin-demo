package com.unrec.demo.samples

fun combine(vararg pairs: Pair<String, Any?>) = pairs.joinToString(", ") { "${it.first}=${it.second}" }

fun main() {
    val pair = "message" to "GlobalExceptionHandler handling LimitsException"
    val combined = combine(pair)
    println("combined = $combined")
}
