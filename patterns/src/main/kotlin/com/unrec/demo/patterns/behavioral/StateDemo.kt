/*
Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
 */

package com.unrec.demo.patterns.behavioral

import com.unrec.demo.patterns.behavioral.State.MaintenanceRequired
import com.unrec.demo.patterns.behavioral.State.StandBy
import com.unrec.demo.patterns.behavioral.State.Working

fun main() {
    val dishwasher = Dishwasher()
    repeat(7) {
        dishwasher.turnOn()
    }
    println("-----")
    dishwasher.repair()
    dishwasher.turnOn()
}

interface Operations {
    fun turnOn()
    fun repair()
}

class Dishwasher : Operations {

    private var state: State = StandBy
    private var cyclesLeft = 3

    override fun turnOn() {
        state = when (state) {
            is StandBy -> {
                if (cyclesLeft > 0) {
                    println("Starting to work")
                    cyclesLeft--
                    Working
                } else {
                    println("The dishwasher requires a maintenance")
                    MaintenanceRequired
                }
            }

            is MaintenanceRequired -> {
                println("Please provide a maintenance")
                state
            }

            is Working -> {
                println("Turning off")
                StandBy
            }
        }
    }

    override fun repair() {
        state = when (state) {
            is MaintenanceRequired -> {
                println("Dishwasher was repaired")
                cyclesLeft = 10
                StandBy
            }

            else -> {
                println("Dishwasher is not broken")
                state
            }
        }
    }
}

sealed class State {

    object StandBy : State()
    object Working : State()
    object MaintenanceRequired : State()
}
