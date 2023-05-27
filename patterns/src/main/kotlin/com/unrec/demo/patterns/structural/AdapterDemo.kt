/*
The Adapter acts as a wrapper between two objects.
It catches calls for one object and transforms them to format and interface recognizable by the second object.
*/

package com.unrec.demo.patterns.structural

fun main() {
    val file: PdfFile = PdfScan(songContent)
    val adapter: ExcelSheet = PdfToExcelAdapter(file)
    val table = TableReader(adapter).readTable()
    println(table)
}

interface PdfFile {
    fun getContent(): String
}

interface ExcelSheet {
    fun getTable(): Table
}

data class Table(
    val headers: List<String>,
    val values: List<String>
)

data class PdfScan(val data: String) : PdfFile {
    override fun getContent(): String = data.replace(oldChar = ',', newChar = '\t')
}

class TableReader(private val excelSheet: ExcelSheet) {

    fun readTable(): String {
        val table = excelSheet.getTable()
        return table.headers.joinToString(separator = ";", postfix = "\n") +
                table.values.joinToString(separator = "\n")
    }
}

class PdfToExcelAdapter(private val pdfFile: PdfFile) : ExcelSheet {

    override fun getTable(): Table {
        val lines = pdfFile.getContent().lines()
        return Table(
            headers = lines.first().split(";"),
            values = lines.subList(1, lines.size)
        )
    }
}

val songContent = """
    artist,track
    Metallica,One
    The Beatles,Yesterday
    The Cardigans,My Favourite Game
""".trimIndent()
