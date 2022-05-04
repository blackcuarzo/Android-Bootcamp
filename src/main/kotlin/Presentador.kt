
class Presentador {
    private val empleados = ConstructorEmpleados().listaEmpleados()
    private val recursosHumanos = Contador(empleados)
    private var estado:Estados = Estados.INICIO
    fun solicitarRespuesta(lectura:String):String{
        return when(lectura){
            "999" ->{
                return menuConsultarTrabajador()
            }
            "1","2","3" -> {
                val opcion = lectura.toInt()
                val empleado = empleados[opcion - 1]
                val salario = recursosHumanos.calcularSalario(empleado)
                return imprimirSalario(empleado,salario) +
                menuConsultarSalario()
            }
            "0" ->{
                estado = Estados.FIN
                return "Fin"
            }
            "Fin"-> "Muchas Gracias"
            else -> {
                mensajeError()
            }
        }
    }
    private fun mensajeError():String{
        return "Opción no disponible"
    }
    private fun menuConsultarTrabajador():String{
        var opciones = ""
        empleados.forEachIndexed { index, empleado -> opciones += "${index+1}. ${empleado.cargo}\n" }
        return ("Seleccione una opción:\n" +
                opciones +
                "0. Salir\n" +
                "Seleccionar opción: \n")
    }
    private fun menuConsultarSalario():String{
        return "Seleccionar opción: \n"
    }
    private fun imprimirSalario(empleado:Empleado, salario:Int):String{
        return "El salario del ${empleado.cargo} es $salario \n"
    }
}


