package com.unrec.demo.samples

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.unrec.demo.samples.GeometryType.SQUARE

enum class GeometryType {
    SQUARE,
    CIRCLE,
    POINT
}

data class GeometryItem(
    val type: GeometryType,
    val geometryJson: String
)

val json = """
        {
            type: "POINT",
            geometryJson: "[12.0, 11.0]"
        }
    """.trimIndent()

fun main() {
    val mapper = jacksonObjectMapper()
    mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
    
    val geometryItem = GeometryItem(SQUARE, "[12.0, 11.0]")
    val geometryItemSerialized = mapper.writeValueAsString(geometryItem)!!
    println("geometryItemSerialized = $geometryItemSerialized")
    
    val geometryItemDeserialized = mapper.readValue<GeometryItem>(json)
    println("geometryItemDeserialized = $geometryItemDeserialized")
}
