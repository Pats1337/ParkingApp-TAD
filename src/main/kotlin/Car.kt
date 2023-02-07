data class Car(val brand: String, val model: String, val number: String) {
    override fun toString(): String {
        return "Автомобиль: $brand $model Гос.номер: $number"
    }
}
