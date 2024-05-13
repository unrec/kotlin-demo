/*
Memento pattern captures object internal state making it easy to store and restore objects in any point of time.
 */

package com.unrec.demo.patterns.behavioral

import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

fun main() {
    val lakers = Team("LA Lakers")
    val nuggets = Team("Denver Nuggets")
    val game = Game(lakers, nuggets)

    val scoreAfterSecondQuarter = game.Score(quater = 2, current = mapOf(lakers to 55, nuggets to 49))

    val scoreInTheMiddleOfThird =
        game.Score(quater = 3, timeElapsed = 6.minutes, current = mapOf(lakers to 63, nuggets to 69))

    game.restoreScore(scoreInTheMiddleOfThird)
    println("Score in the middle of third quarter:")
    println(game.displayScore())

    println("---")

    game.restoreScore(scoreAfterSecondQuarter)
    println("Score after second quarter:")
    println(game.displayScore())
}

class Game(val teamA: Team, val teamB: Team) {

    private var score: Score = Score()

    inner class Score(
        var quater: Byte = 1,
        var timeElapsed: Duration = 12.minutes,
        var current: Map<Team, Int> = mapOf(teamA to 0, teamB to 0)
    )

    fun displayScore() =
        """
        $teamA ${score.current[teamA]} : ${score.current[teamB]} $teamB
        Quarter: ${score.quater}, Time: ${score.timeElapsed}
        """.trimIndent()

    fun restoreScore(score: Score) {
        this.score = score
    }

}


data class Team(val name: String) {
    override fun toString() = name
}
