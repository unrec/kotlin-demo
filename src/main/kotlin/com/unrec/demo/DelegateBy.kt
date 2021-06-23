package com.unrec.demo

interface Player {
    fun play()
    fun pause()
    fun stop()
}

class OldPlayer : Player {
    override fun play() = println("Playing in old-way")
    override fun pause() = println("Pausing in old-way")
    override fun stop() = println("Stopping in old-way")
}

class NewPlayer(val innerPlayer: Player = OldPlayer()) : Player by innerPlayer {
    override fun pause() {
        println("Pausing in new-way")
        innerPlayer.pause()
    }
}

fun main() {
    val player = NewPlayer()
    player.pause()
}