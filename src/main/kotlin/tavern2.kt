import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10

fun main() {
    val orderName = "shandy,Dragon's Breath,5.91"
    placeOrder(orderName)
}

fun performPurchase(price: Double){
    for10Chapter.displayBalance()
    val totalPurse = for10Chapter.playerGold + (for10Chapter.playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    println("remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    for10Chapter.playerGold = remainingGold
    for10Chapter.playerSilver = remainingSilver
    for10Chapter.displayBalance()
}
fun displayBalance(){
    println("Player's purse balance: Gold: ${for10Chapter.playerGold}, Silver: ${for10Chapter.playerSilver}")
}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = for10Chapter.TAVERN_NAME.indexOf('\'')
    val tavernMaster = for10Chapter.TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

//    val phrase = "Ah, delicious $name"
//    println("Madrigal exclaims: ${for10Chapter.toDragonSpeak(phrase)}")
    for10Chapter.performPurchase(price.toDouble())
    val phrase = if(name == "Dragon's Breath") {
        "Madrigal exclaims: ${for10Chapter.toDragonSpeak("Ah, delicious $name")}"
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}

fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when(it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }