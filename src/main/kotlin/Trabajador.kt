import kotlin.math.ceil
import kotlin.math.floor

class Trabajador (val cargo:String, private val horasBaseSemana:Int, val pagoHora:Int) {
    val horasBaseMensuales = horasBaseSemana * 4
    val unidadHorasBono = 5
    val unidadHorasExtra = 10
    var horasTrabajadas:Double = 0.0
    var horasBonus:Int = 0


    fun calcularSalario():Int{
        return calcularHorasAPagar()*pagoHora
    }

    fun addHours(horas:Double){
        horasTrabajadas += horas
    }
    fun calcularHorasAPagar():Int{
        //Supuestos: tiene que cumplir 10 horas exactas extra, 5 horas no cuentan para bonus.
        if(ceil(horasTrabajadas)>=horasBaseMensuales+10){
            var calculo = ceil(horasTrabajadas) + calcularBonus()
            return (calculo).toInt()
        }else{
            return ceil(horasTrabajadas).toInt()
        }
    }
    fun calcularBonus():Int{
        val horasExtraTrabajadas = (ceil(horasTrabajadas) - horasBaseMensuales)
        val numeroDeBonos = floor(horasExtraTrabajadas/unidadHorasExtra).toInt()
        val horasBono = unidadHorasBono * numeroDeBonos
        return horasBono
    }
}