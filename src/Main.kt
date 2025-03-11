fun main() {
    val veterinaria = SistemaVeterinaria("Veterinaria SanPets")

    while (true) {
        println("\n--- Menú de Gestión Veterinaria ---")
        println("1 Registrar Mascota")
        println("2 Registrar Consulta Médica")
        println("3 Mostrar Historial de Consultas")
        println("4 Modificar Peso de Mascota")
        println("5 Modificar Edad de Mascota")
        println("6 Calcular Costo Total de Consultas")
        println("7 Listar Mascotas")
        println("0 Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                print("Especie: ")
                val especie = readLine().orEmpty()
                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Peso (kg): ")
                val peso = readLine()?.toFloatOrNull() ?: 0f

                val nuevaMascota = Mascota(nombre, especie, edad, peso)
                veterinaria.registrarMascota(nuevaMascota)
            }

            2 -> {
                print("ID de la mascota: ")
                val id = readLine()?.toIntOrNull()
                print("Diagnóstico: ")
                val diagnostico = readLine().orEmpty()
                print("¿Incluye medicación? (sí/no): ")
                val incluyeMedicacion = readLine()?.equals("sí", ignoreCase = true) == true

                if (id != null) {
                    veterinaria.registrarConsulta(id, diagnostico, incluyeMedicacion)
                } else {
                    println("⚠ ID inválido.")
                }
            }

            3 -> {
                print("ID de la mascota: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    veterinaria.mostrarHistorialConsultas(id)
                } else {
                    println("⚠ ID inválido.")
                }
            }

            4 -> {
                print("ID de la mascota: ")
                val id = readLine()?.toIntOrNull()
                print("Nuevo peso (kg): ")
                val nuevoPeso = readLine()?.toFloatOrNull()

                if (id != null && nuevoPeso != null) {
                    veterinaria.modificarPesoMascota(id, nuevoPeso)
                } else {
                    println("⚠ Datos inválidos.")
                }
            }

            5 -> {
                print("ID de la mascota: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    veterinaria.modificarEdadMascota(id)
                } else {
                    println("⚠ ID inválido.")
                }
            }

            6 -> {
                print("ID de la mascota: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    veterinaria.calcularCostoTotalConsultas(id)
                } else {
                    println("⚠ ID inválido.")
                }
            }

            7 -> veterinaria.listarMascotas()

            0 -> {
                println(" x Saliendo del sistema...")
                break
            }

            else -> println("⚠ Opción inválida, intente de nuevo.")
        }
    }
}
