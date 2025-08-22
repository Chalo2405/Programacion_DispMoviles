
fun main() {
    var rendimiento: String
    println("Ingresa tu Salario")
    var salario = readln().toDouble()
    println("Ingresa tu puntuacion")
    var puntuacion: Int = readln().toInt() // usamos readln para leer lo que  el usuario coloca con su respectiva condicion
    when (puntuacion) { // Usamos when para tener el rango de la puntuacion y enseñar el respectivo rendimiento
        in 0..3 ->{
            rendimiento="Inaceptable"
            salario=salario+((puntuacion/10)*salario)
        }
        in 4..6 -> {
            rendimiento = "Aceptable"
            salario=salario+((puntuacion/10)*salario) // se divide entre 10 como tambien se podria mutliplicar * 0.1 para sacar ese aumento de salario
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