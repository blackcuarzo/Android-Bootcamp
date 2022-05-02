import kotlin.math.floor

class Trabajador (val cargo:String,val pagoHora:Int, val horasBaseSemana:Int = 48, val unidadHorasBono:Int = 5, val unidadHorasExtra:Int = 10) {
    val horasBaseMensuales:Int
        get() {return horasBaseSemana * 4}
    var horasTrabajadas:Int = 0


    fun calcularSalario():Int{
        return calcularHorasAPagar(horasTrabajadas)*pagoHora
    }

    fun addHours(horas:Int){
        horasTrabajadas += horas
    }
    fun calcularHorasAPagar(horasTrabajadas:Int):Int{
        //Supuestos: tiene que cumplir 10 horas exactas extra, 5 horas no cuentan para bonus.
        if(horasTrabajadas>=horasBaseSemana+unidadHorasExtra){
            var calculo = horasTrabajadas + calcularBono()
            return (calculo).toInt()
        }else{
            return horasTrabajadas
        }
    }
    fun calcularBono():Int{
        val horasExtraTrabajadas = horasTrabajadas - horasBaseMensuales
        val numeroDeBonos = floor(horasExtraTrabajadas.toDouble()/unidadHorasExtra).toInt()
        val horasBono = unidadHorasBono * numeroDeBonos
        return horasBono
    }
}