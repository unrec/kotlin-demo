package com.unrec.demo.patterns.creational

fun main() {
    val iphone = createPhone("S_Apple_IphoneXS")
    val nokia = createPhone("F_Nokia_3310(2017)")

    println("iphone = $iphone")
    println("nokia = $nokia")
}

interface Phone {
    val manufacturer: String
    val model: String
}

data class Smartphone(
    override val manufacturer: String,
    override val model: String
) : Phone

data class FeaturePhone(
    override val manufacturer: String,
    override val model: String
) : Phone


fun createPhone(code: String): Phone {
    val (type, manufacturer, model) = code.split("_")

    return when (type) {
        "S" -> Smartphone(manufacturer, model)
        "F" -> FeaturePhone(manufacturer, model)
        else -> throw RuntimeException("Unsupported phone type provided = $type")
    }
}
