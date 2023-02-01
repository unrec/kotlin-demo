package com.unrec.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch { // launch a new coroutine and keep a reference to its Job
            delay(5000L)
            println("World!")
        }

        println("Hello")
        job.join() // wait until child coroutine completes
        println("Done")
        delay(2000L)
    }
    println("All Done")
}
