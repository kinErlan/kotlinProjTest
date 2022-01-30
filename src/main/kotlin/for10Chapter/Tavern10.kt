package for10Chapter

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"


val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
val patronList2: MutableList<String> = mutableListOf("Eli2", "Mordoc2", "Sophie2")
val menuList = File("data/tavern-menu-items.txt").readText().split("\n")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()

val patronGold = mutableMapOf<String, Double>()

fun main() {
    val orderName = "shandy,Dragon's Breath,5.91"

    println(patronList.first())
    println(patronList[1])
    println(patronList.last())
    println(message = patronList.getOrElse(4, { "unknown patron" }))

    if (patronList.contains("Eli")) {
        println("Eli's in the back playing cards.")
    } else {
        println("Eli isn't here")
    }

    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("yea< they're seated by the stew kettle.")
    } else {
        println("Nay, hey departed hours ago.")
    }

    println(patronList2)
    patronList2.remove("Eli2")
    patronList2.add("Alex2")
    patronList2.add("Adam2")
    patronList2.add(0, "Alex2")
    patronList2[0] = "Alexis"
    println(patronList2)
    patronList2 -= "Mordoc2"
    println(patronList2)
    patronList2.removeIf({ it.contains("h") })
    println(patronList2)
    println(patronList2.size)

    for (patron in patronList) {
        println("good evening, $patron")
    }

    patronList2.forEach { patron ->
        println("hello patron2 $patron")
    }

    patronList2.forEachIndexed { index, patron ->
        println("hello patron2 $patron, you are #${index + 1} in line")
    }

    menuList.forEachIndexed { index, data ->
        val (type, name, price) = data.split(",")
        println("$type: $name - $price")
    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons.add(name)
    }
    println(uniquePatrons)

    println("***************")
    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
        println("")
    }
    println(patronGold)
    displayPatronBalances()

}

private fun displayPatronBalances() {
    patronGold.forEach{ patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}


fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

//    val phrase = "Ah, delicious $name"
//    println("Madrigal exclaims: ${com.bigherdranch.nyethack.toDragonSpeaknch.nyethack.toDragonSpeak(phrase)}")
    performPurchase(price.toDouble(), patronName)
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name")}"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}

fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }