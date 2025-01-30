
class Coche(
    color: String?,
    marca: String?,
    modelo: String?,
    numCaballos: Int?,
    numPuertas: Int?,
    matricula: String?)
{
    init {
        require(!marca.isNullOrBlank()){throw IllegalArgumentException("El campo MARCA no puede estar vacio")}
        require(!modelo.isNullOrBlank()){throw IllegalArgumentException("El campo MODELO no puede estar vacio")}
        require(color != null){throw IllegalArgumentException("El campo COLOR no puede ser nulo")}
    }

    var color = color
        set(value) {
            if (value != null){
                field = value
            } else {
                throw IllegalArgumentException("El campo COLOR no puede ser nulo")
            }
        }

    var matricula = matricula
        set(value){
            if (value?.length == 7){
                field = value
            } else {
                throw IllegalArgumentException("El campo MATRICULA solo se puede modificar por una que tenga 7 caracteres")
            }
        }

    //val marca = marca.lowercase().replaceFirstChar { it.uppercase() }

    val marca = marca
        get() = field?:"desconocido".lowercase().replaceFirstChar { it.uppercase()
        }

    //val modelo = modelo.lowercase().replaceFirstChar { it.uppercase() }

    val modelo = modelo
        get() = field?:"desconocido".lowercase().replaceFirstChar { it.uppercase() }

    var numCaballos = numCaballos
        set(value) {
            if (value in 70..700){
                field = value
            } else {
                throw IllegalArgumentException("El campo Nº DE CABALLOS solo puede contener valores entre 70 y 700")
            }
        }

    var numPuertas = numPuertas
        set(value) {
            if (value in 3..5){
                field = value
            } else {
                throw IllegalArgumentException("El campo Nº DE PUERTAS solo puede contener valores entre 3 y 5")
            }
        }

    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Color: $color, Nº de caballos: $numCaballos, Nº de puertas: $numPuertas, Matricula: $matricula "
    }

}

/* pide que modifique la marca y el modelo pero segun el enunciado estos no son modificables
 y si lo modifico siendo un val no se compila*/



fun main() {

    val coche1 = Coche("Rojo", "Seat", "Leon", 140, 4, "1234ABC")
    val coche2 = Coche("Azul", "BMW", "A7", 95, 3, "1234ABD")
    val coche3 = Coche("Amarillo", "Ford", "fiesta", 240, 5, "1234ABE")
    val coche4 = Coche("Azul oscuro", "Ford", "Focus", 345, 3, "1234ABF")
    val coche5 = Coche("Blanco", "Toyota", "Cupra", 540, 4, "1234ABG")

    val coches = mutableListOf(coche1, coche2, coche3, coche4, coche5)

    for (coche in coches){
        println(coche)
    }

    try {
        coche2.numCaballos = 40
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche3.numPuertas = 2
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche3.matricula= "1234AB"
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche1.matricula = ""
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    for (coche in coches){
        println(coche)
    }
}