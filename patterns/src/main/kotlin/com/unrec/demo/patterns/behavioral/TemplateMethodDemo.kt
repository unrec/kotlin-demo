/*
Template Method pattern outlines the general steps in the parent class and lets the concrete child implementations define the details.
 */

package com.unrec.demo.patterns.behavioral

fun main() {
    println("Preparing 4 Seasons...")
    ForSeasonsPizza().cook()

    println("=====")

    println("Preparing Margherita...")
    Margherita().cook()
}

abstract class PizzaMaker {

    protected var price: Int = 0

    abstract fun addSauce()
    abstract fun addToppings()
    abstract fun slice()


    fun cook() {
        fun prepareDough() = println("Preparing standard dough")
        fun rollOut() = println("Rolling out the dough")
        fun bake() = println("Baking for 10 min")
        fun serve() = println("Serving pizza. Additional price is: $price EUR")

        prepareDough()
        rollOut()
        addSauce()
        addToppings()
        bake()
        slice()
        serve()
    }
}


class ForSeasonsPizza : PizzaMaker() {
    override fun addSauce() {
        this.price += 2
        println("Adding tomato sauce")
    }

    override fun addToppings() {
        this.price += 5
        println("Adding toppings: olives, mushrooms, artichokes, basil")

    }

    override fun slice() = println("Slice in 8 pcs.")
}

class Margherita : PizzaMaker() {
    override fun addSauce() {
        this.price += 3
        println("Adding tomato sauce with garlic and olive oil")
    }

    override fun addToppings() {
        this.price += 6
        println("Adding toppings: mozzarella, garlic, fresh basil, and extra-virgin olive oil")
    }

    override fun slice() = println("Slice in 6 pcs.")
}
