package com.bigherdranch.nyethack

fun main(){
    runSimulation()
}

inline fun runSimulation(){
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Erlan"))
    println(greetingFunction("Erlan2"))
}

fun configureGreetingFunction(): (String)->String {
    val structureType = "hospitals"
    var numBuildings = 5
    return {playerName: String ->
        val currentYear = 2022
        numBuildings += 1
        println("adding $numBuildings $structureType")
        "welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}