fun main(args: Array<String>) {
    println("Введите \"/start\" для начала работы ")
    var startApp = readLine()
    while (true) {
        when (startApp) {
            Command.startCommand -> {
                println("Добро пожаловать в приложение парковки")
                Parking.createParking()
                mainMenu()
                break
            }

            else -> {
                println("Команда введена не верно. Введите \"/start\" для начала работы ")
                startApp = readLine()
            }
        }
    }
}

fun mainMenu() {
    var command = readLine()
    while (true) {
        when (command) {

            Command.helpCommand -> {
                println(
                    "Доступные команды:\n" +
                            "   /help - Информация о доступных командах;\n" +
                            "   /end - Завершение работы приложения;\n" +
                            "   /park - Припарковать автомобиль на свободное место;\n" +
                            "   /return - Возврат автомобиля владельцу;\n" +
                            "   /park_info_by_car - Узнать на каком месте припаркован автомобиль по ее гос. номеру;\n" +
                            "   /park_info_by_place - Узнать какой автомобиль припаркован на конкретном месте;\n" +
                            "   /park_stats - Узнать текущую загрузку парковки;\n" +
                            "   /park_all_stats - Узнать сколько автомобилей было припарковано за текущую сессию."
                )
                command = readLine()
            }

            Command.endCommand -> {
                println("Хорошего дня!")
                break
            }

            Command.parkStatsCommand -> {
                Manager.parkStats()
                command = readLine()
            }

            Command.parkAllStatsCommand -> {
                Manager.parkAllStats()
                command = readLine()
            }

            Command.parkCommand -> {
                println("Для парковки Вашего автомобиля введите следующие данные:\nМарка и модель автомобиля Гос.номер Имя и Фамилия владельца")
                Manager.parkCar()
                command = readLine()
            }

            Command.returnCommand -> {
                println("Для возврата автомобиля назовите Ваше имя и фамилию")
                Manager.returnCar()
                command = readLine()
            }

            Command.parkInfoByCarCommand -> {
                println("Для поиска автомобиля на парковке введите его гос. номер")
                Manager.parkInfoByCar()
                command = readLine()
            }

            Command.parkInfoByPlaceCommand -> {
                println("Для вывода информации введите номер парковочного места")
                Manager.parkInfoByPlace()
                command = readLine()
            }

            else -> {
                println(
                    "Введенная Вами команда не найдена. " +
                            "Введите \"/help\" для получения списка возможных команд."
                )
                command = readLine()
            }
        }
    }
}