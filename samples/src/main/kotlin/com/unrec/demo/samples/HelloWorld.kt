package com.unrec.demo.samples

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Hello, World!")
    } else {
        val name: String = args[0]
        println("Hello, $name!")
    }
}
