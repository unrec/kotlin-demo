package com.unrec.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

fun main() {
    println("Before a coroutine...")

    // runs a new coroutine and blocks the current thread interruptibly until its completion
    runBlocking {
        val jobs: List<Job> = List(100) {
            launch {
                println(Thread.currentThread())
                delay(5.seconds) // suspend the coroutine execution
                print(".")
            }
        }
        jobs.forEach { job: Job -> job.join() } // the main thread is suspended until all jobs will be finished
        println("\nThe coroutine ended")
    }
    println("After the coroutine. Finishing the program")
}

val fibonacci = sequence {
    var a = 0
    var b = 1
    yield(1)

    while (true) {
        yield(a + b)
        val tmp = a + b
        a = b
        b = tmp
    }
}

//fun main() {
//    val ints = fibonacci.take(5).toList()
//    println("ints = $ints")
//}
