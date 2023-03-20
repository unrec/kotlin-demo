package com.unrec.demo.patterns.creational

fun main() {
    val httpClient = HttpClient.withMethod("PUT")
    println("httpClient.method = ${httpClient.method}")
}

// the static behaviour is managed by companion object
class HttpClient private constructor(val method: String) {

    companion object {
        fun withMethod(method: String) = HttpClient(method)
    }
}
