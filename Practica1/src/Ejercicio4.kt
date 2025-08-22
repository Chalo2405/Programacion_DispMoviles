
fun main() {
    var rendimiento: String
    println("Ingresa tu Salario")
    var salario = readln().toDouble()
    println("Ingresa tu puntuacion")
    var puntuacion: Int = readln().toInt()
    when (puntuacion) {
        in 0..3 ->{
            rendimiento="Inaceptable"
            salario=salario+((puntuacion/10)*salario)
        }
        in 4..6 -> {
            rendimiento = "Aceptable"
            salario=salario+((puntuacion/10)*salario)
        }
        in 7..10->{
            rendimiento = "Meritorio"
            salario=salario+((puntuacion/10)*salario)
        }
        else -> {
            rendimiento = "No definido"
            println("ERROR : ingresa un numero del 0 al 10")
        }

    }

    println("Resultado: Tu nivel de rendimiento es: $rendimiento, cantidad de Dinero Recibido: $salario ")

}