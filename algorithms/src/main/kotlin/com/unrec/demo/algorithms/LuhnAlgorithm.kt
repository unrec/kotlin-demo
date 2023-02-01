package com.unrec.demo.algorithms

fun luhn1(number: String): Boolean {
    if (number.length != 16) return false

    val (digits, others) = number
        .filterNot(Char::isWhitespace)
        .partition(Char::isDigit)

    if (digits.length <= 1 || others.isNotEmpty()) {
        return false
    }

    val checksum = digits
        .map { Character.getNumericValue(it) }
        .mapIndexed { index, value ->
            if (index % 2 == 0 && value < 9) value * 2 % 9 else value
        }
        .sum()
    return checksum % 10 == 0
}

fun luhn2(number: String): Boolean {
    var checksum = 0

    for (i in number.length - 1 downTo 0 step 2) {
        checksum += number[i] - '0'
    }
    for (i in number.length - 2 downTo 0 step 2) {
        val n: Int = (number[i] - '0') * 2
        checksum += if (n > 9) n - 9 else n
    }
    return checksum % 10 == 0
}

fun luhn3(number: String): Boolean {
    val (digits, others) = number
        .filterNot(Char::isWhitespace)
        .partition(Char::isDigit)

    if (digits.length <= 1 || others.isNotEmpty()) {
        return false
    }

    val checksum = digits
        .map { it.code - '0'.code }
        .reversed()
        .mapIndexed { index, value ->
            if (index % 2 == 1 && value < 9) value * 2 % 9 else value
        }
        .sum()
    return checksum % 10 == 0
}
