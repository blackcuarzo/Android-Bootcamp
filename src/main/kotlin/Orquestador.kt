class Orquestador {
    private var estado:Estados = Estados.INICIO
    private val presentador = Presentador()
    fun run(){
        when(estado) {
            Estados.INICIO -> iniciarInterfaz()
            Estados.CONSULTAR,Estados.CONSULTARSALARIOS  -> consultarTrabajador()
            Estados.FIN -> {}
        }
    }
    private fun iniciarInterfaz(){
        presentador.menuInicio()
            when (readln()){
                "2" -> {
                    estado = Estados.CONSULTAR
                    presentador.mensajesCambioEstado(estado)
                }
                "0" ->{
                    estado = Estados.FIN
                    presentador.mensajesCambioEstado(estado)
                }
                else -> {
                    presentador.mensajeError()
                }
            }
        run()
    }

    private fun consultarTrabajador(){
        if (estado == Estados.CONSULTAR) presentador.menuConsultarTrabajador() else presentador.menuConsultarSalario()
        when (val opcion = readln()){
                "1","2","3" -> {
                    estado = Estados.CONSULTARSALARIOS
                    val rol = Rol.values()[opcion.toInt()-1]
                    presentador.imprimirSalario(rol)
                }
                "0" -> {
                    estado = Estados.INICIO
                }
                else -> presentador.mensajeError()
            }
        run()
    }
}