//Gerente se gana 200 por hora y trabaja 200 horas al mes
//Operador se gana 10 por hora y trabaja 230 horas al mes
//Contador se gana 50 por hora y trabaja 200 horas al mes
class ConstructorTrabajadores {
    val gerente = Trabajador("Gerente",48,200)
    val operador = Trabajador("Operador",48,10)
    val contador = Trabajador("Contador",48,50)
    init {
        gerente.addHours(200.0)
        operador.addHours(230.0)
        contador.addHours(200.0)
    }
}