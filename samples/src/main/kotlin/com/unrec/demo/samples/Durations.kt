package com.unrec.demo.samples

import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.toDuration

val totalMin = 235118

fun main() {
    val hours = totalMin / 60
    val mins = totalMin % 60
    val days = hours / 24
    val leftHours = hours % 24

    println("days = $days")
    println("hours = $leftHours")
    println("mins = $mins")


    val minutes = totalMin.minutes
    println("minutes = $minutes")

    val twoHours = 120
    println("2 hours = ${twoHours.minutes}")

    val test = 600
    val duration = test.toDuration(DurationUnit.SECONDS)
    println("duration = $duration")
}
