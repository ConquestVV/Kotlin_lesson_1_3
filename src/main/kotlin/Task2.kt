package ru.netology

fun main() {
    val amount = 800_000.0
    val maxValue = 750_000.0
    val typeCard = "VK Pay"
    val previousTransfer = 0.0

    val commissionRate = calculateCommission(amount, maxValue, typeCard)
    val commissionAmount = amount * commissionRate
    val result = amount + commissionAmount

    val maxTransferLimit = when (typeCard) {
        "VK Pay" -> 40_000_00.0
        else -> 600_000_00.0
    }

    if (amount > maxTransferLimit || amount + previousTransfer > maxTransferLimit) {
        println("Превышен лимит перевода!")
    } else {
        val totalTransferred = previousTransfer + amount
        println("Сумма перевода с комиссией: ${formatToRubles(result)}")
        println("Переведено в этом месяце: ${formatToRubles(totalTransferred)}")
        println("Комиссия составила: ${formatToRubles(commissionAmount)}")
    }
}

fun calculateCommission(amount: Double, maxValue: Double, typeCard: String): Double {
    return if (amount <= maxValue) {
        when (typeCard) {
            "MasterCard", "Maestro" -> 0.0
            "Visa", "MIR" -> 0.0075
            else -> 0.0
        }
    } else {
        when (typeCard) {
            "MasterCard", "Maestro" -> 0.006
            "Visa", "MIR" -> 0.0075
            else -> 0.0
        }
    }
}

fun formatToRubles(amount: Double): String {
    val totalKopecks = amount.toInt()
    val rubles = totalKopecks / 100
    val kopecks = totalKopecks % 100
    return "$rubles руб. $kopecks коп."
}
