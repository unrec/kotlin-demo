/*
Visitor pattern allows adding new behaviors to existing class hierarchy without altering any existing code.
*/

package com.unrec.demo.patterns.behavioral

import com.unrec.demo.patterns.behavioral.Shape.Circle
import com.unrec.demo.patterns.behavioral.Shape.Rectangle
import com.unrec.demo.patterns.behavioral.Shape.Triangle
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {

    val visitor = AreaVisitor()
    val area = Area()

    val circle = Circle(10)
    val rectangle = Rectangle(10, 20)
    val triangle = Triangle(1, 2, 5)

    area.drawIn(listOf(circle, rectangle, triangle))

    val result = area.accept(visitor)
    println("result = $result")
}

// can be refactored as a functional interface so the instantiation can be simplified:
// val visitor = Visitor { .. }
interface Visitor {

    fun visit(element: Shape): Double
}

class AreaVisitor : Visitor {

    override fun visit(element: Shape): Double {

        return when (element) {
            is Circle -> element.radius.toDouble().pow(2) * 22 / 7
            is Rectangle -> (element.width * element.height).toDouble()
            is Triangle -> {
                with(element) {
                    val p = a + b + c
                    sqrt((p * (p - a) * (p - b) * (p - c)).toDouble())
                }
            }
        }
    }
}

sealed interface Shape {

    fun accept(visitor: Visitor) = visitor.visit(this)

    class Circle(val radius: Int) : Shape

    class Rectangle(val width: Int, val height: Int) : Shape

    class Triangle(val a: Int, val b: Int, val c: Int) : Shape
}

class Area {

    private lateinit var elements: List<Shape>

    fun drawIn(elements: List<Shape>) {
        this.elements = elements
    }

    fun accept(visitor: Visitor): Double = elements
        .sumOf { it.accept(visitor) }
        .let { DecimalFormat("#.##").format(it).toDouble() }
}
