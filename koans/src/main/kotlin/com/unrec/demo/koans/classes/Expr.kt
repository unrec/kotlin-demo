package com.unrec.demo.koans.classes

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression") // can be removed if Expr is sealed
    }

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main() {
    val five = Num(5)
    println(eval(five))

    val twoPlusSeven = Sum(Num(2), Num(7))
    println(eval(twoPlusSeven))
}
