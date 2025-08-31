class CuentaBancaria( var limiteRetiro: Double) {

    var saldo: Double = 0.0  // establecemos con set el saldo
        set(value) {
            if (value >= 0) field = value
            else println("El saldo no puede ser negativo.")
        }

    fun depositar(monto: Double) { // funcion para depositar dinero
        if (monto > 0) {
            saldo += monto
            println("Deposito exitoso. Saldo actual: $saldo")
        } else {
            println("Monto invalido.")
        }
    }

    fun retirar(monto: Double) { // funcion para retirar el dinero , si excede el limite bota el error
        if (monto > saldo) {
            println("Fondos insuficientes.")
        } else if (monto > limiteRetiro) {
            println("Excede el limite de retiro.")
        } else if (monto > 0) {
            saldo -= monto
            println("Retiro exitoso. Saldo actual: $saldo")
        } else {
            println("Monto invalido.")
        }
    }

    fun verSaldo() { //funcion para visualizar tu saldo
        println("Saldo actual: $saldo")
    }
}

fun main() {
    val cuenta = CuentaBancaria(500.0) // definimos el limite de retiro
    cuenta.saldo = 1000.0

    var opcion: Int // creamos el menu para que el usuario escoja su funcion
    do {
        println("\n--- MENÚ ---")
        println("1. Ver saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Opcion: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> cuenta.verSaldo()
            2 -> {
                print("Monto a depositar: ")
                val monto = readLine()?.toDoubleOrNull() ?: 0.0
                cuenta.depositar(monto)
            }
            3 -> {
                print("Monto a retirar: ")
                val monto = readLine()?.toDoubleOrNull() ?: 0.0
                cuenta.retirar(monto)
            }
            4 -> println("Saliendo...")
            else -> println("Opción invalida.")
        }
    } while (opcion != 4)
}
