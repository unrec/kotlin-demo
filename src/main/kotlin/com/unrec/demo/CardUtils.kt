package com.unrec.demo

private const val unmaskedSymbol = '#'
private val cardRegex = "^[0-9]{16}$".toRegex()
private val maskRegex = "^[xX#]{16}$".toRegex()

fun maskNumber(mask: String, number: String): String {
    validate(cardRegex, number)
    validate(maskRegex, mask)

    val maskedNumber = StringBuilder()
    for (i in mask.indices) with(maskedNumber) {
        val char = mask[i]
        if (char == unmaskedSymbol) append(number[i]) else append(char)
    }
    return maskedNumber.toString()
}

private fun validate(regex: Regex, target: String) {
    if (!(regex matches target)) {
        throw IllegalArgumentException("Input parameter `$target` has incorrect format.")
    }
}

fun main() {
    val number = "5100691470738273"
    val mask = "XXXXXXXXXXXX####"

    val result = maskNumber(mask, number)

    println("result = $result")
}
