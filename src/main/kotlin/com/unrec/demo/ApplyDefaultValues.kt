package com.unrec.demo

import java.math.BigDecimal

data class LimitDto(
    val id: Int? = null,
    val value: BigDecimal,
    val type: String,
    val period: String,
    val country: String? = null
)
val defaults = listOf(
    LimitDto(id = 1, value = BigDecimal("5000.00"), type = "SPENDING_LIMIT", period = "DAILY"),
    LimitDto(id = 2, value = BigDecimal("1000.00"), type = "WITHDRAWAL_LIMIT", period = "DAILY"),
    LimitDto(id = 3, value = BigDecimal("1000.00"), type = "SINGLE_LIMIT", period = "MONTHLY"),
)

val countrySpecific = listOf(
    LimitDto(id = 4, value = BigDecimal("2000.00"), type = "SPENDING_LIMIT", period = "DAILY", country = "DEU"),
    LimitDto(id = 5, value = BigDecimal("800.00"), type = "WITHDRAWAL_LIMIT", period = "DAILY", country = "DEU"),
)

fun main() {
    // in case we don't have some country specific value based on type and period we get the default value
    val list = defaults.map { dto ->
        countrySpecific.find { it.type == dto.type && it.period == dto.period } ?: dto
    }
    list.forEach { println(it) }
}
