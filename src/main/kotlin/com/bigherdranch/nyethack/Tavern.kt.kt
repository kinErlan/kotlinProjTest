package com.bigherdranch.nyethack

fun main(args: Array<String>) {

    println("beverage 1")
    var beverage = readLine()?.let {
        if(it.isNotBlank()) {
            it.replaceFirstChar { it.uppercase() }
        } else {
            "Buttered Ale"
        }
    }
    println(beverage)

    println("beverage 2")
    var beverage2 = readLine()!!.replaceFirstChar { it.uppercase() }
    println(beverage2)

    println("beverage 3")
    var beverage3 = readLine()
    beverage3 = beverage3?.replaceFirstChar { it.uppercase() }?.plus("!!!!!")
    println(beverage3)

    println("beverage 4")
    var beverage4 = readLine()
    val beverageServed: String = beverage4 ?: "buttered ale"
    println(beverage4)
}