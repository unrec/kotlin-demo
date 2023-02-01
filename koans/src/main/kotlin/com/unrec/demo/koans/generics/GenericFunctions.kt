package com.unrec.koans.generics

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(
    col1: C,
    col2: C,
    predicate: (T) -> Boolean): Pair<C, C> {
    for (el in this) {
        if (predicate(el)) {
            col1.add(el)
        } else col2.add(el)
    }
    return Pair(col1, col2)
}

fun partitionWordsAndLines(): Pair<List<String>, List<String>> {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
    return Pair(words, lines)
}

fun partitionLettersAndOtherSymbols(): Pair<HashSet<Char>, HashSet<Char>> {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
    return Pair(letters, other)
}

fun main() {
    val (words, lines) = partitionWordsAndLines()
    println("words = $words")
    println("lines = $lines")

    val (letters, otherChars) = partitionLettersAndOtherSymbols()
    println("letters = $letters")
    println("otherChars = $otherChars")
}
