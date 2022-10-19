package com.unrec.demo

import java.util.UUID

val paths = listOf(
    "service://attachments/AttachmentId(value=8ffb807a-bbcf-426e-9dbf-03c7d798f476)/file1.pdf",
    "service://attachments/AttachmentId(value=ec44ee0d-de5f-4608-bfe0-af9d6a603038)/file2.pdf"
)

private val regex = "\\(value=(.*)\\)".toRegex()

private fun String.toUUID() = UUID.fromString(this)

fun main() {
    val matchResults: List<MatchResult> = paths.map { regex.find(it)!! }
    val uuidList = matchResults.map { it.groupValues[1].toUUID() }
    println("uuidList = $uuidList")
}
