package com.unrec.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

fun main() {
    println("Before a coroutine...")

    // starts a new coroutine
    runBlocking {
        val jobs: List<Deferred<Int>> = List(1000) {
            async {// start multiple operations concurrently
                delay((0..10).random().seconds) // suspend the coroutine execution
                (0..100).random()
            }
        }
        jobs.forEach { deferred: Deferred<Int> -> println(deferred.await()) } // suspends until deferred is complete
        println("\nThe coroutine ended")
    }
    println("After the coroutine. Finishing the program")
}

