package com.generetics

class LootBox<T>(item: T){
    private var loot: T = item
    var open = false

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}

class Fedora(val name: String, val value: Int)
class Coin(val value: Int)

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
    lootBoxOne.open = true

    lootBoxOne.fetch()?.run {
        println("you retrieve $name from the box!")
    }

    val coin = lootBoxOne.fetch() {
        Coin(it.value * 3)
    }

    coin?.let{ println(it.value) }
}