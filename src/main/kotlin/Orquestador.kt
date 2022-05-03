class Orquestador {
    val trabajadores = Trabajadores()

    private var estado:String? = null
    fun run(){
        when(estado) {
            null -> iniciarInterfaz()
            "Inicio" -> iniciarInterfaz()
            "Consultar" -> menuConsultarTrabajador()
            "VerSalario" -> menuConsultarSalario()
            "End" -> {} //Nothing for end yet
        }
    }
    fun iniciarInterfaz(){
        println("Bienvenido")
        estado = "Inicio"
        println("Seleccione una opción:\n")
        println("1. Ingresar")
        println("2. Consultar")
        println("0. Salir")
        while(true){
            when (readln()){
                "1" -> {
                    estado = "Ingresar"
                    println("Opción Ingresar seleccionada")
                    break
                }
                "2" -> {
                    estado = "Consultar"
                    println("Opción Consultar seleccionada")
                    break
                }
                "0" ->{
                    estado = "End"
                    println("Muchas gracias")
                    break
                }
                else -> println("Opción no disponible")
            }
        }
        run() // vuelvo a consultar estados
    }

    fun menuConsultarTrabajador(){
        println("Seleccione una opción:\n")
        println("1. Gerente")
        println("2. Operario")
        println("3. Contador")
        println("0. Volver al menu anterior")
        var opcion: String
        while(true){
            opcion = readln()
            when (opcion){
                //"1","2","3" -> println("Opción $opcion seleccionada")
                "1" -> {
                    //estado = "VerSalario"
                    println("El salario del ${trabajadores.gerente.cargo} es ${trabajadores.gerente.calcularSalario()}")
                    break
                }
                "2" -> {
                    println("El salario del ${trabajadores.operador.cargo} es ${trabajadores.operador.calcularSalario()}")
                    break
                }
                "3" -> {
                    println("El salario del ${trabajadores.contador.cargo} es ${trabajadores.contador.calcularSalario()}")
                    break
                }
                "0" -> {
                    estado = "Inicio"
                    break
                }
                else -> println("Opción no disponible")
            }
        }
        run()
    }

    fun menuConsultarSalario(){
        println("El salario del trabajador es: ")
        print("2. Operario")
        println("3. Contador")
        var opcion: String
        while(true){
            opcion = readln()
            when (opcion){
                "1","2","3" -> {
                    estado = "VerSalario"
                    println("Opción $opcion seleccionada")
                    break
                }
                else -> println("Opción no disponible")
            }
        }
    }


}