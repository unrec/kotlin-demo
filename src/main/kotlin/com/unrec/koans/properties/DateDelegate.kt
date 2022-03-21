package com.unrec.koans.properties

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        return timeInMillis!!.toDate()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        timeInMillis = value.toMillis()
    }
}

fun main() {
    val effectiveDate = EffectiveDate<String>()
    effectiveDate.timeInMillis = 100000
    val obj = D()
    obj.date = MyDate(2022, 21, 3)
    println("date = ${obj.date}")
}