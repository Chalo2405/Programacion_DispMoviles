fun main() {
    val eleccioncomputadora = (1..30).random() // usamos random para que la computadora elija un numero del 1 al 30
    var intentos = 5 // definimos el numero de intentos

    while (intentos > 0) { // usamos este while para controlar los intentos
        println("Elige un numero del 1 al 30")
        val eleccionusuario = readln().toInt()

        if (eleccionusuario !in 1..30) {
            println("Error: el número debe estar entre 1 y 30")
            continue // usamos este continue por si el usuario ingresa un numero no valido, haciendo que su turno no se pierda
        }

        if (eleccionusuario > eleccioncomputadora) {
            intentos-- // restamos intentos para que se vayan disminuyendo cada vez que se equivoca
            println("El número de la computadora es menor, vuelve a intentarlo. Te quedan $intentos intentos")
        } else if (eleccionusuario < eleccioncomputadora) {
            intentos--
            println("El número de la computadora es mayor, vuelve a intentarlo. Te quedan $intentos intentos")
        } else {
            println("FELICIDADES! ACERTASTE!")
            return // usamos retrurn para que el proceso finalice si se haya antes de los intentos dados
        }
    }

    println("GAME OVER! El número era $eleccioncomputadora")
}
