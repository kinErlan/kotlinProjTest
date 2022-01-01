fun main(){

    runSimulation("erl", ::ptintConstructionCost) { playerName, numBuilding->
        val currentYear = 2022
        println("adding $numBuilding houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

inline fun runSimulation(playerName: String, costPrinter: (Int)->Unit, greetingFunction: (String, Int)->String){
    val numBuilding = (1..3).shuffled().last()
    costPrinter(numBuilding)
    println(greetingFunction(playerName,numBuilding))
}

fun ptintConstructionCost(numBuildings:Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}