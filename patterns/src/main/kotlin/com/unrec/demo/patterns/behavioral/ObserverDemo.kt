/*
The Observer pattern deals with an object (called the subject), which maintains a list of its dependents (observers),
and notifies them automatically of any state changes, usually by calling one of their methods.
 */

package com.unrec.demo.patterns.behavioral

import java.time.LocalDateTime

fun main() {

    val fox = Channel { println("This is FOX: ${it.content}, source: FOX©") }
    val espn = Channel { println("This is ESPN News: ${it.content}, source: ${it.source}. Read next..") }
    val cbs = Channel {
        println("This is CBS News: ${it.content}, source: ${it.source}, author: ${it.author}. Date: ${it.date.toLocalDate()}.")
    }

    val publisher = NewsPublisher().also {
        it.subscribe(fox)
        it.subscribe(espn)
        it.subscribe(cbs)
    }

    val royIsAnnounced = News(
        date = LocalDateTime.now(),
        author = "John Doe",
        source = "Yahoo",
        content = "Victor Wembanyama wins NBA Rookie of the Year via unanimous vote after delivering on unprecedented hype"
    )

    publisher.notify(royIsAnnounced)
}


fun interface Channel {
    fun update(news: News)
}

data class News(
    val date: LocalDateTime,
    val author: String,
    val source: String,
    val content: String
)

class NewsPublisher {
    private var channels = mutableSetOf<Channel>()

    fun subscribe(channel: Channel) {
        channels.add(channel)
    }

    fun unsubscribe(channel: Channel) {
        channels.remove(channel)
    }

    fun notify(news: News) = channels.forEach { it.update(news) }
}
