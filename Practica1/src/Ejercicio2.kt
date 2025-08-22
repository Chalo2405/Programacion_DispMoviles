fun main() {
    val opciones = listOf("Piedra", "Tijera", "Papel")

    println("Elige una opción:")
    println("1: Piedra")
    println("2: Tijera")
    println("3: Papel")

    val eleccionUsuario = readln().toInt()
    val jugador = opciones[eleccionUsuario - 1]

    val eleccionComputadora = (1..3).random()
    val computadora = opciones[eleccionComputadora - 1]

    println("Tú elegiste: $jugador")
    println("La computadora eligió: $computadora")

    val resultado = when {
        jugador == computadora -> "Empate"
        jugador == "Piedra" && computadora == "Tijera" -> "Ganaste"
        jugador == "Tijera" && computadora == "Papel" -> "Ganaste"
        jugador == "Papel" && computadora == "Piedra" -> "Ganaste"
        else -> "Perdiste"
    }

    println("Resultado: $resultado")
}
