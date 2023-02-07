object Parking {
    val parking = mutableMapOf<String, String>()

    fun createParking() {
        for(i in 1..20){
            parking["P$i"] = "Свободно"
        }
    }

}