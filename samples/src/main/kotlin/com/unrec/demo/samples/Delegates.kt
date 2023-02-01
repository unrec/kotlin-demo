package com.unrec.demo.samples

class Personal {
    var attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        attributes[attrName] = value
    }

    val name: String by attributes
    val company: String by attributes
}

fun main() {
    val p = Personal()
    val data = hashMapOf("name" to "Dmitry", "company" to "JetBrains")

    for ((attrName, value) in data)
        p.setAttribute(attrName, value)

    println(p.name)
    println(p.company)
}
