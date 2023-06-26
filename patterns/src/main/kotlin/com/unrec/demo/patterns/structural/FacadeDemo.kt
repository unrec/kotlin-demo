/*
Facade pattern provides a unified interface to a set of interfaces in a subsystem.
Facade defines a higher-level interface that makes the subsystem easier to use.
*/

package com.unrec.demo.patterns.structural

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.brew("Cappuccino")
}

class CoffeeMachine {
    private val boiler = Boiler()
    private val roaster = Roaster()
    private val grinder = Grinder()

    fun brew(flavor: String): CoffeeCup {
        boiler.boilWater()
        roaster.roastBeansFor(flavor)
        grinder.grind()
        boiler.heatMilk()
        boiler.steam()
        println("Serving a cup of $flavor")
        return CoffeeCup(4, 5)
    }
}

class Boiler {
    fun boilWater() {
        println("Boiling the water..")
    }

    fun heatMilk() {
        println("Heating the milk..")
    }

    fun steam() {
        println("Steaming..")
    }


}

class Roaster {

    fun roastBeansFor(flavor: String) {
        println("Roasting coffee beans for $flavor")
    }
}

class Grinder {
    fun grind() {
        println("Grinding roasted beans")
    }
}

data class CoffeeCup(
    val price: Int,
    val strength: Int
)
