/*
* chapter 3
* */
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints: Int = 88
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = fomatHealthStatus(healthPoints, isBlessed)

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "keepers of the Mines"
        "gnome" -> "keepers of the Mines"
        "orc" -> "free people of the rolling hills"
        else -> {
            "free people of the rolling hills"
        }
    }
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    return if (auraVisible) "GREEN" else "NONE"
}

private fun fomatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
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

private fun castFireball(numFireballs: Int = 2) = println("a glass of Fireball springs into existence. (x$numFireballs)")

fun shoukdReturnAString(): String{
    TODO("TEST")
}