/*
Compose objects into tree structures to represent part-whole hierarchies.
Composite lets clients treat individual objects and compositions of objects uniformly.
 */

package com.unrec.demo.patterns.structural

import com.unrec.demo.patterns.structural.Product.ApplePhone
import com.unrec.demo.patterns.structural.Product.Box
import com.unrec.demo.patterns.structural.Product.Display

fun main() {

    //put inside the 1st box
    val iPhoneXs = ApplePhone("XS")
    val iPhonePro = ApplePhone("14 Pro")
    val firstBox = Box(listOf(iPhoneXs, iPhonePro))

    // put inside the 2nd box
    val iPhone5S = ApplePhone("5S")
    val asusDisplay = Display("Asus")
    val nestedBox = Box(listOf(asusDisplay))
    val secondBox = Box(listOf(iPhone5S, nestedBox))

    //put separately
    val dellDisplay = Display("Dell")
    val hpDisplay = Display("HP")

    val rootBox = Box(listOf(firstBox, secondBox, dellDisplay, hpDisplay))

    println("Total price = ${rootBox.getPrice()}")
}

interface Item {

    fun getPrice(): Int
}

sealed class Product : Item {

    class ApplePhone(private val model: String) : Product() {
        override fun getPrice(): Int {
            return when (model) {
                "XS" -> 500
                "5S" -> 150
                "14 Pro" -> 1300
                else -> throw IllegalArgumentException("Unknown iPhone model")
            }
        }
    }

    class Display(private val model: String) : Product() {

        var driverVersion: String = "1.0.0"

        override fun getPrice(): Int {
            return when (model) {
                "Dell" -> 300
                "HP" -> 400
                "Asus" -> 250
                else -> throw IllegalArgumentException("Unknown display model")
            }
        }
    }

    class Box(private val items: List<Item>) : Product() {
        override fun getPrice() = items.sumOf(Item::getPrice)
    }
}
