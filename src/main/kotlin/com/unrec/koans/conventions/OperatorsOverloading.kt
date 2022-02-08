package com.unrec.koans.conventions

import com.unrec.koans.conventions.TimeInterval.WEEK
import com.unrec.koans.conventions.TimeInterval.YEAR

enum class TimeInterval { DAY, WEEK, YEAR }

class MultipleTimeInterval(val timeInterval: TimeInterval, val amount: Int)
operator fun TimeInterval.times(number: Int) = MultipleTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeIntervals: MultipleTimeInterval): MyDate =
    addTimeIntervals(timeIntervals.timeInterval, timeIntervals.amount)

fun main() {
    val date = MyDate(2022, 1, 1)

    val datePlusYearAndWeek = date + YEAR + WEEK
    println("datePlusYearAndWeek = $datePlusYearAndWeek")

    val someDayInFuture = date + YEAR * 2 + WEEK * 3 + TimeInterval.DAY * 5
    println("someDayInFuture = $someDayInFuture")
}