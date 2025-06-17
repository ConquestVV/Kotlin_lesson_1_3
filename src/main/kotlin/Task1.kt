package ru.netology

fun main() {
    val wasOnline = 128000
    val time = secondsConverter(wasOnline)
    val message = messageConverter(time, wasOnline)
    val status = agoToText(wasOnline, time, message)
    println(status)
}

fun messageConverter(time: Int, wasOnline: Int): String {
    val cost = time % 10
    val message = if (wasOnline >= 60 * 60 && wasOnline < 24 * 60 * 60)
        when (cost) {
            1 -> "час"
            in 2..4 -> "часа"
            else -> "часов"
        } else
        when (cost) {
            1 -> "минуту"
            in 2..4 -> "минуты"
            else -> "минут"
        }
    return message
}


fun secondsConverter(wasOnline: Int): Int {
    val time = if (wasOnline >= 60 && wasOnline < 60 * 60)
        wasOnline / 60 else if (wasOnline >= 60 * 60 && wasOnline < 24 * 60 * 60)
        wasOnline / 3600 else wasOnline
    return time
}

fun agoToText(wasOnline: Int, time: Int, message: String): String {
    val status =
        when (wasOnline) {
            in 0..60 -> "был(а) в сети только что"
            in 61..60 * 60 -> "был(а) в сети $time $message назад"
            in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети $time $message назад"
            in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети вчера"
            in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети позавчера"
            else -> "был(а) в сети давно"
        }
    return status
}