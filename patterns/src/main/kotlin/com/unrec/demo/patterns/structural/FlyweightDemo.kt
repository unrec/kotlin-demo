/*
Flyweight is an object that minimizes memory use by sharing as much data as possible with other similar objects.
It is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.
*/

package com.unrec.demo.patterns.structural

import kotlin.random.Random

fun main() {
    val tilesSet = HashSet<Tile>()

    repeat(20) {
        repeat(40) {
            val tile = MosaicFactory().getTile(Random.nextInt(1, 4))
            tilesSet.add(tile)
            print(tile.getImage())
        }
        println()
    }
    println("Different tiles used = ${tilesSet.size}")
}

class MosaicFactory {
    fun getTile(code: Int): Tile {
        return when (code) {
            1 -> Square
            2 -> Triangle
            3 -> Fisheye
            else -> throw IllegalArgumentException("Undefined Tile with code $code")
        }
    }
}

interface Tile {
    val description: String?
    fun getImage(): String
}

object Square : Tile {
    override val description: String = "Filled square"
    override fun getImage() = "■"
}

object Triangle : Tile {
    override val description: String = "Filled triangle"
    override fun getImage() = "▲"
}

object Fisheye : Tile {
    override val description: String? = null
    override fun getImage() = "◉"
}
