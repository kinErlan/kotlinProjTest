package com.bigherdranch.nyethack

import java.util.*

class Player {
    var name = "madrigal"
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value) {
            field = value.trim()
        }

    var healthPoints: Int = 88
    val isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) = println(
        "a glass of Fireball springs into existence. (x$numFireballs)"
    )

    fun auraColor(isBlessed: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return if (auraVisible) "GREEN" else "NONE"
    }

    fun fomatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> " is in excellent condition!"
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
