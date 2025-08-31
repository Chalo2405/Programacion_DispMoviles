// clase abstracta en donde tenemos el area perimetro y los resultados de cada figura , siempre usaremos esto
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

// sublclase cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea(): Double = lado * lado
    override fun calcularPerimetro(): Double = 4 * lado
}

// subclase rectangulo
class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override fun calcularArea(): Double = base * altura
    override fun calcularPerimetro(): Double = 2 * (base + altura)
}

// Subclase circulo
class Circulo(val radio: Double) : Shape() {
    override fun calcularArea(): Double = 3.1416 * radio * radio
    override fun calcularPerimetro(): Double = 2 * 3.1416 * radio
}


fun main() {
    println("Ingrese el lado del cuadrado:") // pedimos al usuario que nos de la info de cada figura
    val lado = readLine()?.toDouble() ?: 0.0
    val cuadrado = Cuadrado(lado)

    println("\nIngrese la base del rectángulo:")
    val base = readLine()?.toDouble() ?: 0.0
    println("Ingrese la altura del rectángulo:")
    val altura = readLine()?.toDouble() ?: 0.0
    val rectangulo = Rectangulo(base, altura)

    println("\nIngrese el radio del círculo:")
    val radio = readLine()?.toDouble() ?: 0.0
    val circulo = Circulo(radio)

    println("\n--- Resultados ---")
    println("\nCuadrado:")
    cuadrado.imprimirResultados()

    println("\nRectángulo:")
    rectangulo.imprimirResultados()

    println("\nCírculo:")
    circulo.imprimirResultados()
}
