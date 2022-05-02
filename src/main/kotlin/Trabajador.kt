import kotlin.math.ceil
import kotlin.math.floor

class Trabajador (val cargo:String, val horasBaseSemana:Int = 48, val pagoHora:Int,val unidadHorasBono:Int = 5, val unidadHorasExtra:Int = 10) {
    val horasBaseMensuales = horasBaseSemana * 4

    var horasTrabajadas:Double = 0.0


    fun calcularSalario():Int{
        return calcularHorasAPagar(horasTrabajadas)*pagoHora
    }

    fun addHours(horas:Double){
        horasTrabajadas += horas
    }
    fun calcularHorasAPagar(horasTrabajadas:Double):Int{
        //Supuestos: tiene que cumplir 10 horas exactas extra, 5 horas no cuentan para bonus.
        if(ceil(horasTrabajadas)>=horasBaseSemana+unidadHorasExtra){
            var calculo = ceil(horasTrabajadas) + calcularBono()
            return (calculo).toInt()
        }else{
            return ceil(horasTrabajadas).toInt()
        }
    }
    fun calcularBono():Int{
        val horasExtraTrabajadas = (ceil(horasTrabajadas) - horasBaseMensuales)
        val numeroDeBonos = floor(horasExtraTrabajadas/unidadHorasExtra).toInt()
        val horasBono = unidadHorasBono * numeroDeBonos
        return horasBono
    }
}