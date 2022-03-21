package com.unrec.koans.properties

class LazyProperty(val initializer: () -> Int) {
    var value: Int? = null
    val lazy: Int
        get() {
            if (value == null) {
                value = initializer()
            }
            return value!!
        }

    val lazyValue: Int by lazy(initializer)

}

fun main() {
    val initializer: () -> Int = { 42 }
    val obj = LazyProperty(initializer)
    println("lazy = ${obj.lazy}")
    println("lazyValue = ${obj.lazyValue}")
}