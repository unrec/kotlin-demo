/*
The Chain of Responsibility design pattern is aimed at achieving loose coupling in software design.
In this pattern, a client passes a request to a chain of objects or receivers for processing.
 */

package com.unrec.demo.patterns.behavioral

fun main() {
    val request1 = Request("abc@inbox.com", "jake.smith")
    val request2 = Request("xyz@mail.com", "john.connor")

    val validUserChain = whitelistedName(finalValidation())
    val validUserEmailChain = validEmail(validUserChain)

    runCatching {
        val validEmailChainResult = validUserChain(request1)
        println("validEmailChainResult = $validEmailChainResult")
    }.onFailure {
        println(it.message)
    }

    val validUserEmailChainResult = validUserEmailChain(request2)
    println("validUserEmailChainResult = $validUserEmailChainResult")
}

data class Request(val email: String, val username: String)

@JvmInline
value class Result(val isValid: Boolean)

typealias Validator = (request: Request) -> Result

private val validEmail: (Validator) -> (Request) -> Result = fun(next: Validator) =
    fun(request: Request): Result {
        if (!request.email.matches(emailRegex)) {
            throw IllegalArgumentException("Wrong email format")
        }
        return next(request)
    }

private val whitelistedName: (Validator) -> (Request) -> Result = fun(next: Validator) =
    fun(request: Request): Result {
        if (blackListedUsers.contains(request.username)) {
            throw IllegalArgumentException("Blacklisted user")
        }
        return next(request)
    }

private val finalValidation: () -> (Request) -> Result = fun() =
    fun(request: Request): Result {
        println("$request is valid")
        return Result(true)
    }

private val emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$".toRegex()

private val blackListedUsers = listOf("jane.doe", "jake.smith", "brad.pit")
