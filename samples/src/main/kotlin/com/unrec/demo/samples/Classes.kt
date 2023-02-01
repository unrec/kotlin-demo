package com.unrec.demo.samples

class User(val name: String, val rating: Int) {
    override fun equals(other: Any?): Boolean {
        if (other !is User) return false
        return name == other.name && rating == other.rating
    }

    override fun hashCode() = javaClass.hashCode()
}


class Tree(name: String)

fun main() {
    val john = User("John", 42)
    val jane = User("Jane", 69)
    val johnClone = User("John", 42)

    println(john == johnClone)

    val set = hashSetOf<User>()
    set.add(john)
    println(set.contains(john))
    println(set.contains(johnClone))
    println(set.javaClass)
}
