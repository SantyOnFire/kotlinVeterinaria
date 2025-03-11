class SistemaVeterinaria(val nombreClinica: String) {
    private val mascotas = mutableListOf<Mascota>()
    private val consultas = mutableListOf<ConsultaMedica>()

    fun registrarMascota(mascota: Mascota) {
        mascotas.add(mascota)
        println(" Mascota '${mascota.nombre}' registrada con éxito.")
    }

    fun registrarConsulta(mascotaId: Int, diagnostico: String, incluyeMedicacion: Boolean) {
        val mascota = mascotas.find { it.id == mascotaId }
        mascota?.let {
            val consulta = ConsultaMedica(it, diagnostico, incluyeMedicacion)
            consultas.add(consulta)
            println("🩺 Consulta registrada: ${consulta.describirConsulta()}")
        } ?: println("⚠ No se encontró una mascota con ID $mascotaId.")
    }

    fun mostrarHistorialConsultas(mascotaId: Int) {
        val historial = consultas.filter { it.mascota.id == mascotaId }
        if (historial.isNotEmpty()) {
            println("📜 Historial de consultas para la mascota con ID $mascotaId:")
            historial.forEach { println(it.describirConsulta()) }
        } else {
            println(" No hay consultas registradas para esta mascota.")
        }
    }

    fun modificarPesoMascota(mascotaId: Int, nuevoPeso: Float) {
        val mascota = mascotas.find { it.id == mascotaId }
        mascota?.let {
            it.actualizarPeso(nuevoPeso)
            println("⚖ Peso de '${it.nombre}' actualizado a ${it.peso} kg.")
        } ?: println("⚠ Mascota con ID $mascotaId no encontrada.")
    }

    fun modificarEdadMascota(mascotaId: Int) {
        val mascota = mascotas.find { it.id == mascotaId }
        mascota?.let {
            it.incrementarEdad()
            println("La edad de '${it.nombre}' ahora es ${it.edad} años.")
        } ?: println("Mascota con ID $mascotaId no encontrada.")
    }

    fun calcularCostoTotalConsultas(mascotaId: Int): Float {
        val costoTotal = consultas.filter { it.mascota.id == mascotaId }
            .sumOf { it.costo.toDouble() }
            .toFloat()

        println("💰 Costo total de consultas para la mascota con ID $mascotaId: $$costoTotal")
        return costoTotal
    }

    fun listarMascotas() {
        if (mascotas.isNotEmpty()) {
            println("🐾 Lista de mascotas registradas:")
            mascotas.forEach { println(it.describirMascota()) }
        } else {
            println("⚠ No hay mascotas registradas.")
        }
    }
}