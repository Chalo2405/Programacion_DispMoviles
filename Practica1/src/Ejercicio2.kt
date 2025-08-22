fun main() {
    val opciones = listOf("Piedra", "Tijera", "Papel") // tenemos un array el cual nos servira mas adelante

    println("Elige una opción:")
    println("1: Piedra")
    println("2: Tijera")
    println("3: Papel")

    val eleccionUsuario = readln().toInt()
    val jugador = opciones[eleccionUsuario - 1] // usamos -1 ya que como es un array va del 0 al 2

    val eleccionComputadora = (1..3).random() // usamos random aqui para que la computadora elija entre las 3 opciones
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
