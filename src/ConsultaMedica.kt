import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ConsultaMedica(
    val mascota: Mascota,
    val diagnostico: String,
    val incluyeMedicacion: Boolean = false
) {
    val fecha: String = obtenerFechaActual()
    val costo: Float = calcularCosto()

    private fun calcularCosto(costoBase: Float = 50f): Float {
        return if (incluyeMedicacion) costoBase * 1.15f else costoBase
    }

    private fun obtenerFechaActual(): String {
        val fechaHora = LocalDateTime.now()
        val formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return fechaHora.format(formato)
    }

    fun describirConsulta(): String {
        val medicacion = if (incluyeMedicacion) "Sí" else "No"
        return "Fecha: $fecha, Mascota: ${mascota.nombre}, Diagnóstico: $diagnostico, Medicación: $medicacion, Costo: $${"%.2f".format(costo)}"
    }
}
