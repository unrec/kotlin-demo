package com.unrec.demo.koans.conventions

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    // return date in first.rangeTo(last)
    return date in first..last
}

fun main() {
    val date = MyDate(2005, 5, 25)
    val start = MyDate(1999, 12, 31)
    val end = MyDate(2036, 4, 26)
    println(checkInRange(date, start, end))
}
