interface IRoles{
}
enum class Rol (val pagoHora:Int):IRoles  {
    GERENTE(200),
    OPERARIO(10),
    CONTADOR(50);
    //internal var pagoHora:Int = 0
    internal var horasTrabajadas:Int = 0

    companion object {
//    fun selectorBono() {
//        TODO("Not yet implemented")
//    }
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

fun Rol.selectorBono():Rol{
    val ganadorBono = Rol.values().reduce {
            ganador, competidor ->   if(competidor.horasTrabajadas > ganador.horasTrabajadas) competidor else ganador
    }
    return ganadorBono
}

fun Rol.calcularSalario() :Int {
    if(this == this.selectorBono())
        return (horasTrabajadas+10)*(this.pagoHora)
    else
        return horasTrabajadas*(this.pagoHora)
}

//fun Rol.asignarPagoHora (_pagoHora: Int){
//    pagoHora = _pagoHora
//}
