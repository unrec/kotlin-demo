package com.unrec.koans.conventions

class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override operator fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start

            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                current = current.followingDate()
                return result
            }
        }
    }
}

fun main() {
    val date = MyDate(2022, 2, 8)
    println("date.followingDate() = ${date.followingDate()}")

    val dateRange = DateRange(date, MyDate(2022, 2, 28))
    dateRange.forEach { println(it) }
}
