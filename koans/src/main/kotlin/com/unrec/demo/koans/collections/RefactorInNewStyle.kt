package com.unrec.demo.koans.collections

fun doSomethingWithCollectionNewStyle(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }

    val maximumSizeOfGroup = groupsByLength.values.map { it.size }.maxOrNull()

    return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup }
}

fun doSomethingWithCollectionOldStyle(collection: Collection<String>): Collection<String>? {
    val groupsByLength = mutableMapOf<Int, MutableList<String>>()
    for (s in collection) {
        var strings: MutableList<String>? = groupsByLength[s.length]
        if (strings == null) {
            strings = mutableListOf()
            groupsByLength[s.length] = strings
        }
        strings.add(s)
    }

    var maximumSizeOfGroup = 0
    for (group in groupsByLength.values) {
        if (group.size > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size
        }
    }

    for (group in groupsByLength.values) {
        if (group.size == maximumSizeOfGroup) {
            return group
        }
    }
    return null
}

