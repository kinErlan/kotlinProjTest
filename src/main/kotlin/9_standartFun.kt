fun main( ){
    fun nameIsLong(name: String) = name.length >= 20

    fun playerCreateMessage(nameTooLong: Boolean): String {
        return if(nameTooLong) {
            "name in too long. please choose another name"
        } else {
            "welcome, adventure!"
        }
    }

    "polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

}