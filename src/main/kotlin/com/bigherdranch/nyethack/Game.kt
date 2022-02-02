package com.bigherdranch.nyethack

import kotlin.system.exitProcess

/*
* chapter 3
* */
fun main(args: Array<String>) {
    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())
    exitProcess(0)

    val player: Player = Player("madrigal",true,true,)

    val auraColor = player.auraColor(player.isBlessed)

    val healthStatus = player.fomatHealthStatus(player.healthPoints, player.isBlessed)

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "keepers of the Mines"
        "gnome" -> "keepers of the Mines"
        "orc" -> "free people of the rolling hills"
        else -> {
            "free people of the rolling hills"
        }
    }
    printPlayerStatus(player)
    player.castFireball()
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor(player.isBlessed)} Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.fomatHealthStatus(player.healthPoints, player.isBlessed)}")
}



fun shouldReturnAString(): String{
    TODO("TEST")
}