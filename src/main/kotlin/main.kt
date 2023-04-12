import java.lang.Double.POSITIVE_INFINITY

fun main() {

    println("Время с последнего посещения в секундах:")
    var t = readln().toInt()        //ввод времени в секундах

    var result = agoToText(t)       //вызов функции для расчета последнего посещения

    println("Пользователь был в сети: $result")
}

fun agoToText(t: Int):String {
    var s = "a"                         // задание результирующей переменной
    var minute : Int = t / 60           // пересчет секунд в минуты
    var hour : Int = t / 3600           // пересчет секунд в часы
    var minuteendings : String = "минут"    // задание переменной для определения окончания (в минутах)
    var hourendings : String = "час"        // задание переменной для определения окончания (в часах)

    when (minute) {
        1, 21, 31, 41, 51 -> minuteendings = "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> minuteendings = "минуты"
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..60-> minuteendings = "минут"
    }

    when (hour) {
        1, 21 -> hourendings = "час"
        2, 3, 4, 22, 23, 24 -> hourendings = "часа"
        in 5..20 -> hourendings = "часов"
    }

    when (t) {
        in 0..60 -> s = "только что"
        in 61..60 * 60 -> s = "$minute $minuteendings назад"
        in 60 * 60 + 1..24 * 60 * 60 -> s = "$hour $hourendings назад"
        in 24 * 60 * 60 + 1 .. 2 * 24 * 60 * 60 -> s = "вчера"
        in 2 * 24 * 60 * 60 + 1 .. 3 * 24 * 60 * 60 -> s = "позавчера"
        in 3 * 24 * 60 * 60..POSITIVE_INFINITY.toInt() -> s = "давно"
    }
    return s
}
