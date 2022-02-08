package com.unrec.koans.conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> this.year - other.year
            month != other.month -> this.month - other.month
            else  -> dayOfMonth - other.dayOfMonth
        }
    }
}

fun main() {
    val date1 = MyDate(2020,3,18)
    val date2 = MyDate(2020,2,18)
    println(date1 < date2)
}