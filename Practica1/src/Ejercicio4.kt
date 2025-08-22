fun suma(num: Double, num2: Double): Double = num + num2
fun resta(num: Double, num2: Double): Double = num - num2
fun mult(num: Double, num2: Double): Double = num * num2
fun dividir(num: Double, num2: Double): Double = num / num2 // Usamos Double en todos debido a que pueden haber numeros que requieran mayor precision

fun main() {
    var opcion: Int

    do {
        println("\n===== MENU =====") // hacemos el menu con las opciones a elegir
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")
        print("Elige una opción: ")
        opcion = readln().toInt() // leemos lo que ingresa el usuario

        if (opcion in 1..4) { // da igual la opcion que elijas (excepto la 5) siempre usaremos 2 numeros para operar
            print("Ingrese el primer número: ")
            val num1 = readln().toDouble()
            print("Ingrese el segundo número: ")
            val num2 = readln().toDouble()

            when (opcion) {
                1 -> println("Resultado: ${suma(num1, num2)}") // en todas hacemos la respectiva llamada de la funcion
                2 -> println("Resultado: ${resta(num1, num2)}")
                3 -> println("Resultado: ${mult(num1, num2)}")
                4 -> {
                    if (num2 != 0.0)
                        println("Resultado: ${dividir(num1, num2)}")
                    else
                        println("No se puede dividir entre 0")
                }
            }
        } else if (opcion != 5) {
            println("Opción inválida, intenta de nuevo.") // si pone otro numero tenemos esta correccion
        }

    } while (opcion != 5) // aqui definimos que siempre que la opcion sea diferente de 5 podremos seguir operando

    println("Programa finalizado.")
}
