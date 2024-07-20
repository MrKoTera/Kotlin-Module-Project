class NoteMenu(private val archive: Archive) : Menu() {

    fun showMenu() {
        while (true) {
            println("Действия над заметками у архива \"${archive.name}\"")
            val options = listOf(
                "Создать заметку" to { createNote() },
                "Просмотр заметок" to { viewNotes() }
            )
            if (!showMenu(options)) {
                return
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = readInput().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }
        println("Введите содержание заметки:")
        val content = readInput().trim()
        if (content.isEmpty()) {
            println("Содержание заметки не может быть пустым.")
            return
        }
        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun viewNotes() {
        if (archive.notes.isEmpty()) {
            println("Заметок внутри архива нет.")
        } else {
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. Название: ${note.title}")
                println("Содержание: ${note.content}")
            }
        }
    }
}
