fun main() {
    val eleccioncomputadora = (1..30).random()
    var intentos = 5

    while (intentos > 0) {
        println("Elige un numero del 1 al 30")
        val eleccionusuario = readln().toInt()

        if (eleccionusuario !in 1..30) {
            println("Error: el número debe estar entre 1 y 30")
            continue
        }

        if (eleccionusuario > eleccioncomputadora) {
            intentos--
            println("El número de la computadora es menor, vuelve a intentarlo. Te quedan $intentos intentos")
        } else if (eleccionusuario < eleccioncomputadora) {
            intentos--
            println("El número de la computadora es mayor, vuelve a intentarlo. Te quedan $intentos intentos")
        } else {
            println("FELICIDADES! ACERTASTE!")
            return
        }
    }

    println("GAME OVER! El número era $eleccioncomputadora")
}
