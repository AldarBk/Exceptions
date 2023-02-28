import java.util.*

class TooHighPressure(message: String) : Exception(message)
class TooLowPressure(message: String) : Exception(message)
class IncorrectPressure(message: String) : Exception(message)

class Wheel(var currentPressure: Double = 0.0) {
    fun inflate(pressure: Double) {
        when {
            pressure < 0 -> throw IncorrectPressure("Давление не может быть отрицательным")
            pressure > 10 -> throw TooHighPressure("Давление высокое")
            pressure < 1.6 -> throw TooLowPressure("Давление слишком низкое")
            pressure > 2.5 -> throw TooLowPressure("Давление влишком высокое, сцепление с дорогой плохое")
            else -> currentPressure = pressure
        }
    }

    fun checkPressure() {
        when {
            currentPressure < 1.6 -> throw TooLowPressure("Давление слишком низкое")
            currentPressure > 2.5 -> throw TooLowPressure("авление влишком высокое, сцепление с дорогой плохое")
            else -> println("Давление в норме")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите текущее давление в колесе:")
    val currentPressure = scanner.nextDouble()
    val wheel = Wheel(currentPressure)
    println("Введите желаемое давление для накачивания колеса:")
    val desiredPressure = scanner.nextDouble()
    try {
        wheel.inflate(desiredPressure)
        println("Накачка прошло успешно. Эксплуатация возможна.")
        wheel.checkPressure()
    } catch (e: TooHighPressure) {
        println("Накачка не удалась: ${e.message}")
    } catch (e: TooLowPressure) {
        println("Накачка не удалась: ${e.message}")
    } catch (e: IncorrectPressure) {
        println("Накачка не удалась: ${e.message}")
    }
}
