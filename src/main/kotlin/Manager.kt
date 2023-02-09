object Manager {

    private var countParking = 0

    private fun getCorrectDetails(reqNumsOfArg: Int): String {
        var correctDetails = false
        var receivedData = mutableListOf<String>()
        while (!correctDetails) {
            val inputData = readLine().toString()
            val splitInputData = inputData.split(" ")
            if (splitInputData.size == reqNumsOfArg) {
                receivedData = splitInputData.toMutableList()
                correctDetails = true
            } else {
                println("Некорректные данные. Попробуйте снова.")
            }
        }
        return receivedData.joinToString(separator = " ")
    }

    fun parkCar() {
        val ownerDetails = getCorrectDetails(5)
        val map = HashMap(Parking.parking)
        var i = 1
        for ((key, value) in map) {
            if (value == "Свободно") {
                Parking.parking[key] = ownerDetails
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

    fun returnCar() {
        val ownerDetails = getCorrectDetails(2)
        val map = HashMap(Parking.parking)
        var i = 1
        for ((key, value) in map) {
            if (value.contains(ownerDetails)) {
                println("Автомобиль успешно возвращен владельцу $ownerDetails")
                Parking.parking[key] = "Свободно"
                break
            } else {
                i++
                if (i == map.size) {
                    i = 1
                    println("Извините, $ownerDetails не парковал у нас свой автомобиль. Попробуйте снова!")

                }
            }
        }

    }

    fun parkInfoByCar() {
        val ownerDetails = getCorrectDetails(1)
        val map = HashMap(Parking.parking)
        var i = 1
        for ((key, value) in map) {
            if (value.contains(ownerDetails)) {
                println("Автомобиль с гос. номером $ownerDetails припаркован на месте $key")
                break
            } else {
                i++
                if (i == map.size) {
                    i = 1
                    println("Автомобиль с гос. номером $ownerDetails не найден. Попробуйте снова!")

                }
            }
        }
    }

    fun parkInfoByPlace() {
        val ownerDetails = getCorrectDetails(1)
        val map = HashMap(Parking.parking)
        var i = 1
            for ((key, value) in map) {
                if (key.contains(ownerDetails)) {
                    if (value.contains("Свободно")) {
                        println("Парковочное место $ownerDetails свободно")
                        break
                    } else {
                        println(
                            "Парковочное место $ownerDetails занято автомобилем: " +
                                    "${value.split(" ")[0]} " +
                                    "${value.split(" ")[1]} " +
                                    "${value.split(" ")[2]} "
                        )
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

    fun parkStats() {
        Parking.parking.forEach { (key, value) ->
            println("$key = $value")
        }
    }

    fun parkAllStats() {
        println("За текущую сессию было припарковано $countParking автомобилей.")
    }
}