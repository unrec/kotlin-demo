package com.unrec.demo.algorithms

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LuhnAlgorithmTest {

    @Test
    internal fun `test all implementations`() {
        val number = "1234560910235463"
        assertAll(
            { assertTrue(luhn1(number)) },
            { assertTrue(luhn2(number)) },
            { assertTrue(luhn3(number)) },
        )
    }
}
