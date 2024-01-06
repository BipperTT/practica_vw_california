
import java.util.Scanner

/**
 * Calcula el precio final.
 * @author BipperTT
 * @since 15/12/2023
 * @param preuCoche Precio original del vehículo.
 * @param km Kilómetros recorridos por el vehículo.
 * @param portabicis Indica si el vehículo tiene un portabicis instalado o no.
 * @param anys Antigüedad del vehículo en años.
 * @return Precio actualizado del vehículo después de aplicar las pérdidas y costos adicionales.
 */
fun precioActual(preuCoche: Int, km: Int, portabicis: Boolean, anys: Int): Float {
    // Pérdida por antigüedad según el rango de años
    val pèrduaAnys = when {
        anys <= 5 -> 0.00001f
        anys in 6..10 -> 0.00002f
        else -> 0.00004f
    }

    // Pérdida de valor por kilómetros recorridos
    val pèrduaQuilòmetres = pèrduaAnys * km

    // Calcular el precio final teniendo en cuenta la antigüedad y kilómetros
    var preuFinal = (preuCoche * (1 - pèrduaQuilòmetres))

    // Añadir costo adicional si el vehículo tiene portabicis
    if (portabicis) {
        preuFinal += 250f
    }

    return preuFinal
}

/**
 * Muestra un menú al usuario y solicita la entrada de un número entero.
 * @author BipperTT
 * @since 15/12/2023
 * @param textoMenu El texto que describe el menú que se presenta al usuario.
 * @return El número entero ingresado por el usuario.
 */
fun menu(textoMenu: String): Int {
    val scan = Scanner(System.`in`)
    var numeroLlegit: Int = 0

    // Mostrar el texto del menú
    println(textoMenu)

    // Bucle do-while para garantizar que se ingrese un número entero válido
    do {
        var valorCorrecte: Boolean = scan.hasNextInt()
        if (!valorCorrecte) {
            scan.nextLine()
        } else {
            numeroLlegit = scan.nextInt()
            scan.nextLine()
        }
    } while (!valorCorrecte)

    return numeroLlegit
}
