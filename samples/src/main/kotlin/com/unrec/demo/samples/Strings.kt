package com.unrec.demo.samples

const val path = "C:/tools/jdk/jdk-11/bin/java.exe"

fun parsePath(path: String) {
    val regex = "^(.+)/(.+)\\.(.+)$".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (path, filename, extension) = matchResult.destructured
        println("Path to folder: $path")
        println("File name: $filename")
        println("File extension: $extension")
    }
}

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun randomStringOf(length: Int): String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

fun main() {
    println("Parsing with String functions:")
    println("Path to folder: ${path.substringBeforeLast("/")}")
    println("File name: ${path.substringAfterLast("/")}")
    println("File extension: ${path.substringAfterLast("/").substringAfterLast(".")}")

    println("\nParsing with regex:")
    parsePath(path)

    println("length")
    println(strLenSafe(null))
    println(strLenSafe("123"))
    println(randomStringOf(10))
}
