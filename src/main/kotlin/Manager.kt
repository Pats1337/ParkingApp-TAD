object Manager {

    private var countParking = 0

    fun checkCorrectInputData(): String {
        var correctInputData = false
        var receivedData = mutableListOf<String>()
        while (!correctInputData) {
            val inputData = readLine()
            val splitInputData = inputData!!.split(" ")
            if (splitInputData.size == 5) {
                receivedData = splitInputData.toMutableList()
                correctInputData = true
            } else {
                println("Некорректные данные.\nВведите данные в следующем порядке: \nМарка автомобиля Цвет автомобиля Гос.номер Имя владельца Фамилия владельца")
            }
        }
        return Car(
            receivedData[0],
            receivedData[1],
            receivedData[2]
        ).toString() + " " +
                Owner(
                    receivedData[3],
                    receivedData[4]
                ).toString()
    }

    fun parkCar(park: MutableMap<String, String>, ownerDetails: String) {
        val map = HashMap(park)
        var i = 1
        for ((key, value) in map) {
            if (value == "Свободно") {
                park[key] = ownerDetails
                println("Автомобиль успешно припаркован! Ваше парковочное место $key")
                countParking++
                break
            } else {
                i++
                if (i == map.size) {
                    println("Извините, свободных мест нет!")
                }
            }
        }
    }

    fun returnCar(park: MutableMap<String, String>) {
        var correctOwner = false
        val map = HashMap(park)
        var i = 1
        while (!correctOwner) {
            val inputData = readLine()
            for ((key, value) in map) {
                if (value.contains(inputData!!)) {
                    println("Автомобиль успешно возвращен владельцу $inputData")
                    park[key] = "Свободно"
                    correctOwner = true
                    break
                } else {
                    i++
                    if (i == map.size) {
                        i = 1
                        println("Извините, введены не корректные данные. Попробуйте снова!")

                    }
                }
            }
        }
    }

    fun parkInfoByCar(park: MutableMap<String, String>) {
        var correctNumber = false
        val map = HashMap(park)
        var i = 1
        while (!correctNumber) {
            val inputData = readLine()
            for ((key, value) in map) {
                if (value.contains(inputData!!)) {
                    println("Автомобиль с гос. номером $inputData припаркован на месте $key")
                    correctNumber = true
                    break
                } else {
                    i++
                    if (i == map.size) {
                        i = 1
                        println("Автомобиль с гос. номером $inputData не найден. Попробуйте снова!")

                    }
                }
            }
        }
    }

    fun parkInfoByPlace(park: MutableMap<String, String>) {
        var correctPlace = false
        val map = HashMap(park)
        var i = 1
        while (!correctPlace) {
            val inputData = readLine()
            for ((key, value) in map) {
                if (key.contains(inputData!!)) {
                    if (value.contains("Свободно")) {
                        println("Парковочное место $inputData свободно")
                        correctPlace = true
                        break
                    } else {
                        println("Парковочное место $inputData занято автомобилем: " +
                                "${value.split(" ")[1]} " +
                                "${value.split(" ")[2]} " +
                                "${value.split(" ")[3]} " +
                                "${value.split(" ")[4]}")
                        correctPlace = true
                        break
                    }
                } else {
                    i++
                    if (i == map.size) {
                        i = 1
                        println("Введен некорректный номер парковочного места. Попробуйте снова!")

                    }
                }
            }
        }
    }

    fun parkStats() {
        Parking.parking.forEach { (key, value) ->
            println("$key = $value")
        }
    }

    fun parkAllStats() {
        println("За текущую сессию было припарковано $countParking автомобилей.")
    }
}