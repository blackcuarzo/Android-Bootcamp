class Orquestador {
    private var estado:Estados = Estados.INICIO
    private val presentador = Presentador()
    fun run(){
        when(estado) {
            Estados.INICIO -> iniciarInterfaz()
            Estados.CONSULTAR -> consultarTrabajador()
            Estados.FIN -> {}
        }
    }
    private fun iniciarInterfaz(){
        presentador.menuInicio()
            when (readln()){
                /*
//                "1" -> {
//                    estado = "Ingresar"
//                    println("Opción ${estado.name.lowercase()} seleccionada")
//                    break
//                }
                 */
                "2" -> {
                    estado = Estados.CONSULTAR
                    println("Opción ${estado.name.lowercase()} seleccionada")
                }
                "0" ->{
                    estado = Estados.FIN
                    println("Muchas gracias")
                }
                else -> {
                    println("Opción no disponible")
                }
            }
        run()
    }

    private fun consultarTrabajador(){
        presentador.menuConsultar()
        print("Seleccionar opción: ")
        when (val opcion = readln()){
                "1","2","3" -> {
                    val rol = Rol.values()[opcion.toInt()-1]
                    println("El salario del ${rol.name.lowercase()} es ${rol.calcularSalario()}")
                }
                "0" -> {
                    estado = Estados.INICIO
                }
                else -> println("Opción no disponible")
            }
        run()
    }

}