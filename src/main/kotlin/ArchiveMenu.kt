class ArchiveMenu : Menu() {
    private val archives = mutableListOf<Archive>()

    fun showMenu() {
        while (true) {
            println("Список архивов: ${if (archives.isEmpty()) "нет архивов" else archives.joinToString(", ") { it.name }}")
            val options = listOf(
                "Создать архив" to { createArchive() },
                "Выбрать архив" to { selectArchive() }
            )
            if (!showMenu(options)) {
                break
            }
        }
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = readInput().trim()
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов для выбора.")
            return
        }
        println("Введите номер архива:")
        archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }

        val choice = readIntInput()
        if (choice == null || choice < 1 || choice > archives.size) {
            println("Неверный ввод. Пожалуйста, введите корректный номер архива.")
        } else {
            val archive = archives[choice - 1]
            val noteMenu = NoteMenu(archive)
            noteMenu.showMenu()
        }
    }
}
