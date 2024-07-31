// Clase base Food
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase Burger
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Asando la hamburguesa: $name"
    }
}

// Subclase Pizza
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Horneando la pizza: $name"
    }
}

// Interfaz Dessert
interface Dessert {
    fun eat(): String
}

// Subclase IceCream que implementa Dessert
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado: $name"
    }

    override fun eat(): String {
        return "Comiendo el helado: $name"
    }
}

// Clase abstracta Drink
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase Juice
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour(): String {
        return "Vertiendo el jugo: $name"
    }

    override fun cook(): String {
        return "Exprimir el jugo: $name"
    }
}

// Extension function para calcular el precio con descuento
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price * (1 - discountPercentage / 100)
}

fun main() {
    // Creación de instancias de diferentes alimentos
    val burger = Burger("Cheeseburger", 5.99)
    val pizza = Pizza("Pepperoni Pizza", 8.99)
    val iceCream = IceCream("Vanilla Ice Cream", 3.50)
    val juice = Juice("Orange Juice", 2.99)

    // Llamada a la función cook() para cada artículo
    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())

    // Llamada a la función eat() en una instancia de IceCream
    println(iceCream.eat())

    // Cálculo e impresión del precio con descuento de una hamburguesa
    val discount = 10.0 // 10% de descuento
    println("Precio con descuento de la hamburguesa: ${burger.discountedPrice(discount)}")
}
