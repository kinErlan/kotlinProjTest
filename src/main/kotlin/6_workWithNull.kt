fun main() {
    // 1 способ
    // оператор безапасного вызова ?.
    // если переменная null следующий оператор не вызовется
    var vers: String? = readLine()
    val sss = vers?.let{if(it.isNotBlank()) {
        it.uppercase()
    } else {
        "empty"
    } }
    println(sss)

    // 2 способ
    // оператор !!.
    // вызовет ошибку если значение null
    var vers2: String?
    vers2 = readLine()
    println(vers2!!.length)

    // 3 спосоп - if

    // 4ый способ
    // ?: - оператор Элвис
    // если операнд слева от меня - null, выполни операцию справа

}