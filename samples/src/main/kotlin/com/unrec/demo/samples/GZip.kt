package com.unrec.demo.samples

import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.charset.StandardCharsets.UTF_8
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

fun gzip(content: String): ByteArray {
    val bos = ByteArrayOutputStream()
    GZIPOutputStream(bos).bufferedWriter(UTF_8).use { it.write(content) }
    return bos.toByteArray()
}

fun ungzip(content: ByteArray): String =
    GZIPInputStream(content.inputStream()).bufferedReader(UTF_8).use { it.readText() }

fun main() {
//    val content = "This is test content for archiving"
//    val zipped = gzip(content)
//    println(zipped.size)

    val file = File("GZip.kt")
    val content = file.readText()

    println("size of original: ${content.length}")
    val zipped = gzip(content)
    println("size zipped: ${zipped.size}")
    val unzipped = ungzip(zipped)
    println("size unzipped: ${unzipped.length}")
    assert(unzipped == content)
}
