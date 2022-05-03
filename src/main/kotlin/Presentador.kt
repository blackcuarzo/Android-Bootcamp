class Presentador {
    fun menuInicio(){
        println("Bienvenido")
        println("Por favor seleccione una opción:\n")
        println("1. Ingresar")
        println("2. Consultar")
        println("0. Salir")
    }
    fun menuConsultar(){
        println("Seleccione una opción:\n")
        Rol.values().forEach{rol -> println("${rol.ordinal+1}. " + rol.name[0].uppercaseChar() + rol.name.lowercase().substring(1) )}
        println("0. Volver al menu anterior")
    }
    fun menuFin(){

    }
    fun imprimirSalario(){
        println("El salario del trabajador es: ")
        print("2. Operario")
        println("3. Contador")
    }
}