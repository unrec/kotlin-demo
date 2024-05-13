/*
The Chain of Responsibility design pattern is aimed at achieving loose coupling in software design.
In this pattern, a client passes a request to a chain of objects or receivers for processing.
 */

package com.unrec.demo.patterns.behavioral

fun main() {

    val request1 = Request("abc@inbox.com", "jake.smith")
    val request2 = Request("xyz@mail.com", "john.connor")
    val chainHandler: Handler = EmailHandler(UsernameHandler(FinalHandler()))

    runCatching {
        println(chainHandler.handleRequest(request1))
    }.onFailure { println(it.message) }

    println(chainHandler.handleRequest(request2))
}


interface Handler {
    var nextHandler: Handler?
    fun handleRequest(request: Request): Result
}

class EmailHandler(override var nextHandler: Handler?) : Handler {
    override fun handleRequest(request: Request): Result {
        if (!request.email.matches(emailRegex)) {
            throw IllegalArgumentException("Wrong email format")
        }
        return nextHandler!!.handleRequest(request)
    }
}

class UsernameHandler(override var nextHandler: Handler?) : Handler {
    override fun handleRequest(request: Request): Result {
        if (blackListedUsers.contains(request.username)) {
            throw IllegalArgumentException("Blacklisted user")
        }
        return nextHandler!!.handleRequest(request)
    }
}

class FinalHandler : Handler {
    override var nextHandler: Handler? = null

    override fun handleRequest(request: Request): Result {
        println("$request is valid")
        return Result(true)
    }
}

private val emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$".toRegex()

private val blackListedUsers = listOf("jane.doe", "jake.smith", "brad.pit")
