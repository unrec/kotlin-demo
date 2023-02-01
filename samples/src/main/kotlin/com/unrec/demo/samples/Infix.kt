package com.unrec.demo.samples

infix fun Int.multiply(other: Int) = this * other
infix fun Int.divide(other: Int) = this / other
infix fun String.append(other: String) = "$this $other"

fun main() {
    println("6*7=${6 multiply 7}")
    println("144/12=${144 divide 12}")
    println("foo" append "bar")
}
