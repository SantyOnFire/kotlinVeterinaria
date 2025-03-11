open class Mascota(
    val nombre: String,
    val especie: String,
    var edad: Int,
    var peso: Float
) {
    val id: Int = hashCode()

    fun actualizarPeso(nuevoPeso: Float) {
        peso = nuevoPeso
        println("Peso de $nombre actualizado a $peso kg")
    }

    fun incrementarEdad() {
        edad++
        println("Edad de $nombre incrementada a $edad años")
    }

    fun describirMascota(): String {
        return "Nombre: $nombre, Especie: $especie, Edad: $edad años, Peso: $peso kg"
    }
}
