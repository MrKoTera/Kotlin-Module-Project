import java.util.Scanner

open class Menu {
    private val scanner = Scanner(System.`in`)

    fun readInput(): String {
        return scanner.nextLine()
    }

    fun readIntInput(): Int? {
        val input = readInput()
        return input.toIntOrNull()
    }

    fun showMenu(options: List<Pair<String, () -> Unit>>): Boolean {
        while (true) {
            options.forEachIndexed { index, pair -> println("${index + 1}. ${pair.first}") }
            println("${options.size + 1}. Выход")

            val choice = readIntInput()
            if (choice == null || choice < 1 || choice > options.size + 1) {
                println("Неверный ввод. Пожалуйста, введите число от 1 до ${options.size + 1}.")
            } else if (choice == options.size + 1) {
                return false
            } else {
                options[choice - 1].second()
            }
        }
    }
}
