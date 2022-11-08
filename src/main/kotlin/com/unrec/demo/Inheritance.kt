package com.unrec.demo

open class Animal(val name: String? = null)

class Cat(name: String?) : Animal(name)
class Dog(name: String?) : Animal(name)
class Hamster(name: String?) : Animal(name)

fun main() {
    val cat = Cat("Keks")
    val dog = Dog("John")
    val hamster = Hamster("Shorty")
    val animals: List<Animal> = listOf(cat, dog, hamster)
    animals.forEach { println(it.name) }
}
