package com.unrec.koans.properties

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++
        }
}

fun main() {
    val obj = PropertyExample()
    obj.counter = 42
    obj.propertyWithCounter = 1
    obj.propertyWithCounter = 2
    obj.propertyWithCounter = 3
    println("obj.counter = ${obj.counter}")
}