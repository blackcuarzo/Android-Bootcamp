
class Presentador {
    private val empleados = ConstructorEmpleados().listaEmpleados()
    private val recursosHumanos = Contador(empleados)
    private var estado:Estados = Estados.INICIO


    fun atenderEstado(estado: Estados): Estados {
        var respuesta = estado
        when(estado) {
            Estados.INICIO -> {
                menuConsultarTrabajador()
                respuesta = Estados.CONSULTAR
            }
            Estados.CONSULTAR ->{

            }
            Estados.FIN -> {}
        }
        return respuesta
    }
    fun solicitarRespuesta(lectura:Int){
        when(lectura){
            1,2,3 -> {
                val empleado = empleados[lectura - 1]
                val salario = recursosHumanos.calcularSalario(empleado)
                imprimirSalario(empleado,salario)
                menuConsultarSalario()
            }
            0 ->{
                estado = Estados.FIN
                mensajesCambioEstado(estado)
            }
            else -> {
                mensajeError()
            }
        }
    }

    private fun String.darFormato():String{
        return this.toByteArray().toString(charset("ISO-8859-1"))
    }
    private fun String.imprimir(){
        println(this.darFormato())
    }
    private fun mensajeError(){
        "Opción no disponible".imprimir()
    }
    private fun menuConsultarTrabajador(){
        var opciones = ""
        empleados.forEachIndexed { index, empleado -> opciones += "${index+1}. ${empleado.cargo}\n" }
        ("Seleccione una opción:\n" +
                opciones +
                "0. Salir\n" +
                "Seleccionar opción: ").imprimir()
    }
    private fun menuConsultarSalario(){
        "Seleccionar opción: ".imprimir()
    }
    private fun mensajesCambioEstado(estado:Estados){
        when(estado){
            Estados.CONSULTAR  -> "Opción ${estado.name.lowercase()} seleccionada".imprimir()
            Estados.FIN -> "Muchas gracias".imprimir()
            else -> {}
        }
    }
    private fun imprimirSalario(empleado:Empleado, salario:Int){
        "El salario del ${empleado.cargo} es $salario".imprimir()
    }
}


