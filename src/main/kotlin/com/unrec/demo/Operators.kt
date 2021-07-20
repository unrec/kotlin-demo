package com.unrec.demo

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.plusAssign(other: Point) {
    Point(x + other.x, y + other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Point.timesAssign(scale: Double) {
    Point((x * scale).toInt(), (y * scale).toInt())
}

fun main() {
    val p1 = Point(10, 10)
    val p2 = Point(20, 20)
    println(p1 + p2)

    val p3 = Point(30, 30)
    p3 += Point(50, 50)
    println(p3)

    val p4 = Point(40, 40)
    val scale = 4.0
    println(p4 * scale)

    val list = ArrayList<Int>()
    list.add(42)
    list += 100
    println(list[0])

    val collection = arrayListOf(1, 2)
    collection += 3
    println(collection)

    val newCollection = collection + listOf(4, 5)
    println(newCollection)
}