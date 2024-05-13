/*
The Mediator pattern defines an object that encapsulates how a set of objects interact.
With this pattern, communication between objects is encapsulated within a Mediator object.
Objects no longer communicate directly with each other, but instead communicate through the Mediator.
This reduces the dependencies between communicating objects, thereby reducing coupling.
*/

package com.unrec.demo.patterns.behavioral

fun main() {
    val lax = ControlTower

    val codes = listOf("ABC123", "DAS393", "ASF3578")
    val planes = codes.map { Airplane(it, lax) }
    planes.forEach { lax.register(it) }

    val privateJet = Airplane("DZD2097", null)

    planes[0].notify("We have enough watter")
    planes[1].requestTakeOff()

    privateJet.checkIn(lax)
    privateJet.notify("Will land in 5 minutes")

    planes[1].checkOut(lax)
    lax.deregister(planes[1])
}

object ControlTower {
    private var participants = mutableListOf<Plane>()

    fun register(plane: Plane) = participants.add(plane)
    fun deregister(plane: Plane) = participants.remove(plane)

    override fun toString(): String = "LAX"
}

interface Plane {

    fun checkIn(tower: ControlTower)

    fun checkOut(tower: ControlTower)

    fun requestTakeOff()

    fun requestLanding()

    fun notify(message: String)
}

class Airplane(private val code: String, private var currentTower: ControlTower?) : Plane {

    override fun checkIn(tower: ControlTower) {
        this.currentTower = tower
        println("$code is joining ${tower}")
    }

    override fun checkOut(tower: ControlTower) {
        this.currentTower = null
        println("$code is leaving $tower")
    }

    override fun requestTakeOff() {
        if (this.currentTower == null) {
            println("Trying to communicate with no Tower")
        } else {
            println("$code: requesting for the take-off")
        }
    }

    override fun requestLanding() {
        if (this.currentTower == null) {
            println("Trying to communicate with no Tower")
        } else {
            println("Request is rejected, please check-in at first")
        }
    }

    override fun notify(message: String) {
        if (currentTower == null) {
            println("Trying to notify no specific Tower")
        } else {
            println("$code: $message")
        }
    }
}


