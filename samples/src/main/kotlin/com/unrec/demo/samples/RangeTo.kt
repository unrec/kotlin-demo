package com.unrec.demo.samples

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> = object : Iterator<LocalDate> {
    var current = start
    override fun hasNext() = current <= endInclusive
    override fun next() = current.apply { current = plusDays(1) }
}

fun main() {
    val now = LocalDate.now()
    val range = now..now.plusDays(10)
    for (day in range) {
        println(day)
    }
}
