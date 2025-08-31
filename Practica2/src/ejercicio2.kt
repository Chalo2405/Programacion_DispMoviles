class Producto {

    var precioBase: Double = 0.0 // definimos con set el precio base y verificamos si cumple con lo requerido
        set(value) {
            if (value > 0) field = value
            else println("El producto debe tener un precio mayor a 0")
        }

    var descuento: Double = 0.0 // definimos con set el descuento y verificamos si cumple con lo requerido
        set(value) {
            if (value in 0.0..100.0) field = value
            else println("El descuento debe estar entre 0 y 100")
        }

    fun calcularPrecioFinal(): Double { // hacemos la operacion para calcular el precio final
        return precioBase - (precioBase * descuento / 100)
    }
}

fun main() {
    val producto = Producto()

    print("Ingrese el precio base: ")
    producto.precioBase = readLine()?.toDouble() ?: 0.0

    print("Ingrese el descuento (%): ")
    producto.descuento = readLine()?.toDouble() ?: 0.0

    println("\n--- RESUMEN DEL PRODUCTO ---") // mostramos el resultado final
    println("Precio base: ${producto.precioBase}")
    println("Descuento: ${producto.descuento}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
