package com.unrec.demo

val path = "C:/tools/jdk/jdk-11/bin/java.exe"

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

fun main() {
    println("Parsing with String functions:")
    println("Path to folder: ${path.substringBeforeLast("/")}")
    println("File name: ${path.substringAfterLast("/")}")
    println("File extension: ${path.substringAfterLast("/").substringAfterLast(".")}")

    println("\nParsing with regex:")
    parsePath(path)
}