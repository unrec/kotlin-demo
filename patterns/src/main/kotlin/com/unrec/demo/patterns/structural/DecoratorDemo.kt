/*
Using the Decorator you can wrap objects countless number of times since both target objects and decorators
follow the same interface. The resulting object will get a stacking behavior of all wrappers.
 */

package com.unrec.demo.patterns.structural

import kotlin.random.Random

fun main() {
    val averagePlayer = AveragePlayer()
    val nonMotivatedPlayer = BackToBack(DeadlineTraded(averagePlayer))
    println("----------")

    println("Before the game:")
    println("Player's speed: ${nonMotivatedPlayer.speed}")
    println("Player's strength: ${nonMotivatedPlayer.strength}")
    println("Player's scoring: ${nonMotivatedPlayer.scoring}")
    println("----------")

    println("During the game:")
    repeat(5) { nonMotivatedPlayer.threePointer() }

    println("----------")
    println("After the game:")
    println("Player's speed: ${nonMotivatedPlayer.speed}")
    println("Player's strength: ${nonMotivatedPlayer.strength}")
    println("Player's scoring: ${nonMotivatedPlayer.scoring}")
    println("3 pointers made: ${nonMotivatedPlayer.threePointersMade}")
}

interface BasketballPlayer {
    var speed: Int
    var strength: Int
    var scoring: Int
    var threePointersMade: Int

    fun threePointer(): Boolean {
        return (randomRateValue() < scoring)
            .also {
                if (it) {
                    threePointersMade += 1
                } else {
                    scoring -= 1
                    strength -= 1
                    speed -= 1
                }
            }
    }
}

class AveragePlayer : BasketballPlayer {
    override var speed: Int = 80
    override var strength: Int = 80
    override var scoring: Int = 80
    override var threePointersMade: Int = 0
}

class BackToBack(private val player: BasketballPlayer) : BasketballPlayer by player {

    init {
        println("To many games in few days..")
    }

    override var speed: Int = player.speed - 5
    override var strength: Int = player.strength - 10
    override var scoring: Int = player.scoring - 5

    override fun threePointer(): Boolean {
        println("Another three attempt..")
        return super.threePointer()
    }
}

class DeadlineTraded(private val player: BasketballPlayer) : BasketballPlayer by player {

    init {
        println("Why I was traded?!?")
    }

    override var speed: Int = player.speed - 2
    override var strength: Int = player.strength - 5
    override var scoring: Int = player.scoring - 3

    override fun threePointer(): Boolean {
        println("Deadline Traded..")
        return super.threePointer()
    }
}

private fun randomRateValue() = Random.nextInt(0, 100)
