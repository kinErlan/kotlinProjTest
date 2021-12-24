/*
* chapter 3
* */
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints: Int = 50
    val isBlessed = true
    val isImmortal = false


    val healthStatus = when(healthPoints) {
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

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "keepers of the Mines"
        "gnome" -> "keepers of the Mines"
        "orc" -> "free people of the rolling hills"
        else -> {
            "free people of the rolling hills"
        }
    }
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if(auraVisible) "GREEN" else "NONE"

    println( "(Aura: $auraColor) Blessed: ${if(isBlessed) "YES" else "NO"})")

    println("$name $healthStatus")
}

