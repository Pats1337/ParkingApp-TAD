fun main(args: Array<String>) {
    print("Введите \"/start\" для начала работы: ")
    var command = readLine()
    while (true) {
        when (command) {
            "/start" -> {
                println("Добро пожаловать в приложение парковки.")
                command = readLine()}
            "/help" -> {
                println(
                    "Доступные команды:\n" +
                            "   /start - Запуск приложения парковки;\n" +
                            "   /help - Информация о доступных командах;\n" +
                            "   /end - Завершение работы приложения."
                )
                command = readLine()
            }
            "/end" -> {
                println("Хорошего дня!")
                break
            }
            else -> {
                println("Введенная Вами команда не найдена. " +
                        "Введите \"/help\" для получения списка возможных команд.")
                command = readLine()
            }
        }
    }
}