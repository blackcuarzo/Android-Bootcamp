interface IRoles{
    val pagoHora:Int
    fun asignarHoras(horas: Int)
}
enum class Rol (override val pagoHora:Int):IRoles  {
    GERENTE(200),
    OPERARIO(10),
    CONTADOR(50);
    internal var horasTrabajadas:Int = 0
    override fun asignarHoras(horas: Int){
        horasTrabajadas = horas
    }

    companion object {
        fun inicializar(){
            CONTADOR.asignarHoras(200)
            GERENTE.asignarHoras(200)
            OPERARIO.asignarHoras(230)
        }
    }
}
fun Rol.sumarHoras(horas: Int){
    horasTrabajadas += horas
}
fun Rol.asignarHoras(){
    Rol.CONTADOR.sumarHoras(200)
    Rol.GERENTE.sumarHoras(200)
    Rol.OPERARIO.sumarHoras(230)
}

fun selectorBono():Rol{
    val ganadorBono = Rol.values().reduce {
            ganador, competidor ->   if(competidor.horasTrabajadas > ganador.horasTrabajadas) competidor else ganador
    }
    return ganadorBono
}

fun Rol.calcularSalario() :Int {
    if(this == selectorBono())
        return (horasTrabajadas+10)*(this.pagoHora)
    else
        return horasTrabajadas*(this.pagoHora)
}

//fun Rol.asignarPagoHora (_pagoHora: Int){
//    pagoHora = _pagoHora
//}
