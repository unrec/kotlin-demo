package com.unrec.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class RunBlockingDemoTest {

    @Test
    fun givenHugeAmountOfCoroutines_whenStartIt_thenShouldExecuteItWithoutOutOfMemory() {
        val callback: (String) -> String = { it.toString() }

        runBlocking {
            //given
            val counter = AtomicInteger(0)
            val numberOfCoroutines = 100_000

            //when
            val jobs = List(numberOfCoroutines) {
                launch {
                    delay(1L)
                    counter.incrementAndGet()
                }
            }
            jobs.forEach { it.join() }

            //then
            assertEquals(counter.get(), numberOfCoroutines)
        }
    }
}

