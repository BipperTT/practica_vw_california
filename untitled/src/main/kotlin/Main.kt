/**
 * Función principal que representa una aplicación para calcular el valor de mercado de un vehículo.
 * @author BipperTT
 * @since 15/12/2023
 */
fun main() {

    val carAsciiArt = "${GREEN}              ______--------___\n" +
            "             /|             / |\n" +
            "  o___________|_\\__________/__|\n" +
            " ]|___     |  |=   ||  =|___  |\"\n" +
            " //   \\\\    |  |____||_///   \\\\|\"\n" +
            "|  X  |\\--------------/|  X  |\\\"\n" +
            " \\___/                  \\___/${RESET}"


    println(carAsciiArt)
    println("${YELLOW_BOLD}Benvingut a l'aplicació per calcular el valor de mercat.${RESET}")

    // Declaración de variables para la entrada de usuario
    var model: Int
    var km: Int
    var preufinal: Float = 0f
    var portabicis: Boolean
    var anys: Int

    // Bucle para solicitar información al usuario hasta que se introduce un modelo válido
    do {

        model = menu("${CYAN}Si tens una Volkswagen Grand California escriu 1, si tens una Volkswagen Grand California Full Equip escriu 2.${RESET}")

        km = menu("${CYAN}Introdueix el número de km que té el vehicle:${RESET}")

        portabicis = menu("${CYAN}El vehicle té portabicis? (1: Sí, 0: No)${RESET}") == 1

        anys = menu("${CYAN}Quants anys té el vehicle?${RESET}")

        if (model == 1) {
            var preuinicial: Int = 73490
            preufinal = precioActual(preuinicial, km, portabicis, anys)
        } else if (model == 2) {
            var preuinicial: Int = 93490
            preufinal = precioActual(preuinicial, km, portabicis, anys)
        } else {
            println("${RED_BOLD}ERROR: Valor introduït incorrecte${RESET}")
        }

    } while (model != 1 && model != 2)

    println("${GREEN_BOLD}El preu final tenint en compte els $km km, $anys anys, els extras i el tipus de model del vehícle, és de $preufinal€.${RESET}")
}
