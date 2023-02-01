package com.unrec.demo.koans.introduction

const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2}\s$month\s\d{4}"""

fun main() {
    val pattern = getPattern().toRegex()
    println("13 JUN 1992".matches(pattern))
    println("8 MCH 2001".matches(pattern))
}
