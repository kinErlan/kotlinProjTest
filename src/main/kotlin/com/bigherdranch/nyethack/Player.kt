package com.bigherdranch.nyethack

import java.io.File
import java.util.*

// переменные класса можно объявлять в конструкторе
// без создания самих переменных в объекте

class Player(
    _name: String,
    val isBlessed: Boolean,
    private val isImmortal: Boolean,
    var healthPoints: Int = 100,
) {
    private val hometown by lazy({ selectHometown() })
    var currentPosition = Coordinate(0,0)

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
        .trim()

    var name = _name
        get() {return "${field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} of $hometown"}
        set(value) {
            field = value.trim()
        }

    init {
        require(healthPoints > 0, { "healthPoints must be a greater than zero" })
        require(name.isNotBlank(), { "Player must have a name" })
    }

    constructor(name: String) : this(
        name,
        isBlessed = true,
        isImmortal = false,
    ) {
        if (name.lowercase() == "kar") healthPoints = 40
    }

    fun castFireball(numFireballs: Int = 2) = println(
        "a glass of Fireball springs into existence. (x$numFireballs)"
    )

    fun auraColor(isBlessed: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return if (auraVisible) "GREEN" else "NONE"
    }

    fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> " has a few scratches"
            in 75..89 -> if (isBlessed) {
                " has some minor wounds but is healing quite quickly"
            } else {
                " has a some minor wounds."
            }
            in 15..74 -> " looks  pretty hurt."
            else -> {
                " is in awful condition."
            }
        }
}
