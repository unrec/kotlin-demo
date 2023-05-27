/*
The official definition for the Bridge design pattern introduced by Gang of Four (GoF) is
to decouple an abstraction from its implementation so that the two can vary independently.
 */

package com.unrec.demo.patterns.structural

import com.unrec.demo.patterns.structural.Suit.DIAMONDS
import com.unrec.demo.patterns.structural.Suit.SPADES

fun main() {
    val kingOfSpades: Card = PlayingCard(King(), SPADES)
    val queenOfDiamonds: Card = PlayingCard(Queen(), DIAMONDS)
    val jackOfDiamonds: Card = PlayingCard(Jack(), DIAMONDS)

    println("King of Spades beats Queen of Diamonds? ${kingOfSpades.beats(queenOfDiamonds)}")
    println("Queen of Diamonds beats Jack Of Diamonds? ${queenOfDiamonds.beats(jackOfDiamonds)}")
}

interface Card {
    val rank: Rank
    val suit: Suit
    fun beats(another: Card): Boolean
}

class PlayingCard(
    override val rank: Rank,
    override val suit: Suit
) : Card {
    override fun beats(another: Card): Boolean {
        return when (this.suit) {
            another.suit -> this.rank.power > another.rank.power
            else -> this.suit.power > another.suit.power
        }
    }
}

interface Rank {
    val power: Int
}

class King : Rank {
    override val power: Int = 13
}

class Queen : Rank {
    override val power: Int = 12
}

class Jack : Rank {
    override val power: Int = 11
}

enum class Suit(val power: Byte) {
    CLUBS(4),
    HEARTS(3),
    DIAMONDS(2),
    SPADES(1)
}
