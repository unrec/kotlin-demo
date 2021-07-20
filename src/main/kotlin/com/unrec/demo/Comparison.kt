package com.unrec.demo

data class Human(val firstName: String, val lastName: String) : Comparable<Human> {
    override fun compareTo(other: Human): Int {
        return compareValuesBy(this, other, Human::lastName, Human::firstName)
    }
}

fun main() {
    val john = Human("John", "Smith")
    val mike = Human("Michael", "Jordan")

    println(john.compareTo(mike))
    println(john < mike)
}
