class Presentador {
    private fun String.darFormato():String{
        return this.toByteArray().toString(charset("ISO-8859-1"))
    }
    private fun String.imprimir(){
        println(this.darFormato())
    }
    fun mensajeError(){
        "Opción no disponible".imprimir()
    }
    fun menuInicio(){
        ("Bienvenido\n" +
                "Por favor seleccione una opción:\n" +
                "1. Ingresar\n" +
                "2. Consultar\n" +
                "0. Salir\n").imprimir()
    }
    fun menuConsultarTrabajador(){
        val opciones = Rol.values().fold(""){texto,rol -> texto + ("${rol.ordinal+1}. " + rol.name[0].uppercaseChar() + rol.name.lowercase().substring(1) +"\n" )
        }
        ("Seleccione una opción:\n" +
                opciones +
                "0. Volver al menu anterior\n" +
                "Seleccionar opción: ").imprimir()
    }
    fun menuConsultarSalario(){
        "Seleccionar opción: ".imprimir()
    }
    fun mensajesCambioEstado(estado:Estados){
        when(estado){
            Estados.CONSULTAR  -> "Opción ${estado.name.lowercase()} seleccionada".imprimir()
            Estados.FIN -> "Muchas gracias".imprimir()
        }
    }
    fun imprimirSalario(rol:Rol){
        "El salario del ${rol.name.lowercase()} es ${rol.calcularSalario()}".imprimir()
    }
}
