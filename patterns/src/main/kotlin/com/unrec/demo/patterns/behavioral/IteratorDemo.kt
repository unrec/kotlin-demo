/*
Iterator provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
 */

package com.unrec.demo.patterns.behavioral

import com.unrec.demo.patterns.structural.Item
import com.unrec.demo.patterns.structural.Product.ApplePhone
import com.unrec.demo.patterns.structural.Product.Box
import com.unrec.demo.patterns.structural.Product.Display

fun main() {

    val firstBox = Box(
        listOf(
            ApplePhone("5S"), ApplePhone("XS"), ApplePhone("14 Pro")
        )
    )

    val secondBox = Box(
        listOf(
            Display("Dell"), Display("HP"), Display("Asus")
        )
    )

    val mainBox = Box(listOf(firstBox, secondBox, ApplePhone("14 Pro")))
    for (item in mainBox) {
        println("${item.javaClass.simpleName} ${item.model} costs ${item.getPrice()}")
    }
}

class ItemIterator(private val items: List<Item>) : Iterator<Item> {

    private var index = 0
    private var iterator: Iterator<Item> = this

    override fun hasNext(): Boolean {
        if (index == items.size - 1 && iterator != this) {
            return iterator.hasNext()
        }
        return index < items.size
    }

    override fun next(): Item {
        if (iterator != this) {
            if (iterator.hasNext()) {
                return iterator.next()
            } else {
                index++
            }
        }

        return when (val item = items[index]) {
            is Box -> {
                iterator = item.iterator()
                this.next()
            }

            else -> {
                index++
                item
            }
        }
    }
}
