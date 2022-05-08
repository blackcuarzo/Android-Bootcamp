interface IEmpleado{
    fun obtenerHorasMes():Int
}

interface IContador{
    fun asignarListaEmpleados(listaEmpleados: Array<Empleado>)
    fun calcularSalario(empleado:Empleado):Int
}


open class Empleado (internal val cargo:String,internal val pagoHora: Int = 0, internal val horasTrabajadas:Int = 0):IEmpleado  {

    override fun obtenerHorasMes(): Int {
        return horasTrabajadas
    }

}
class ConstructorEmpleados{
    val gerente = Empleado(cargo = "gerente",200,200)
    val operador = Empleado(cargo = "operador",10,230)
    val contador = Empleado(cargo = "contador",50,200)
    fun listaEmpleados():Array<Empleado>{
        return arrayOf(operador,contador,gerente)
    }
}

class Contador(private var listaEmpleados: Array<Empleado>):IContador{
    override fun asignarListaEmpleados(listaEmpleados: Array<Empleado>){
        this.listaEmpleados = listaEmpleados
    }
    private fun calcularSalarioBase(empleado: Empleado):Int {
        return empleado.obtenerHorasMes() * empleado.pagoHora
    }
    private fun calcularBono(empleado: Empleado):Int{
        return empleado.pagoHora*10
    }
    override fun calcularSalario (empleado: Empleado):Int{
        val empleadoBono =  listaEmpleados.reduce{
                ganador, competidor ->   if(competidor.horasTrabajadas > ganador.horasTrabajadas) competidor else ganador
        }
        return if (empleado == empleadoBono) {
            calcularSalarioBase(empleado) + calcularBono(empleado)
        }else{
            calcularSalarioBase(empleado)
        }
    }
}
