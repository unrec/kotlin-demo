package com.unrec.demo.patterns.creational

import com.unrec.demo.patterns.creational.SystemProvider.APPLE
import com.unrec.demo.patterns.creational.SystemProvider.MICROSOFT

fun main() {
    val factory = SystemFactoryMaker()
    factory.getFactoryFor(APPLE).also {
        println("Hardware: ${it.createHardware().getDescription()}")
        println("Software: ${it.createSoftware().getDescription()}")
        println("Operator motto: ${it.createOperator().getMotto()}")
    }
}

class SystemFactoryMaker {

    fun getFactoryFor(provider: SystemProvider): SystemFactory = when (provider) {
        APPLE -> AppleSystemFactory()
        MICROSOFT -> WindowsSystemFactory()
    }
}

enum class SystemProvider {
    APPLE, MICROSOFT
}

interface SystemFactory {
    fun createHardware(): Hardware
    fun createSoftware(): OperatingSystem
    fun createOperator(): Operator
}

class AppleSystemFactory : SystemFactory {
    override fun createHardware() = MacBook()
    override fun createSoftware() = MacOS()
    override fun createOperator() = AppleUser()
}

class WindowsSystemFactory : SystemFactory {
    override fun createHardware() = HuaweiLaptop()
    override fun createSoftware() = Windows()
    override fun createOperator() = WindowsUser()
}

interface Hardware {
    fun getDescription(): String
}

interface OperatingSystem {
    val version: String
    fun getDescription(): String
}


interface Operator {
    val experienceLevel: Int

    fun getMotto(): String
}

class MacBook : Hardware {
    override fun getDescription() = "This is best design you have ever seen"
}

class HuaweiLaptop : Hardware {
    override fun getDescription() = "I'm cheaper but also has metal body"
}

class MacOS : OperatingSystem {
    override val version: String = "Ventura"
    override fun getDescription() = "I have a close button somewhere on the left side"
}

class Windows : OperatingSystem {
    override val version: String = "Win11"
    override fun getDescription() = "I have some fresh view, what do you think?"
}

class AppleUser : Operator {
    override val experienceLevel: Int = 70
    override fun getMotto(): String = "Will change phones every September or October!!!"
}

class WindowsUser : Operator {
    override val experienceLevel: Int = 90
    override fun getMotto(): String = "It's not just a computer, it's a lifestyle!"
}
