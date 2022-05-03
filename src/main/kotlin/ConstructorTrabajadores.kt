//Gerente se gana 200 por hora y trabaja 200 horas al mes
//Operador se gana 10 por hora y trabaja 230 horas al mes
//Contador se gana 50 por hora y trabaja 200 horas al mes
class Trabajadores {
    val gerente = Trabajador("Gerente", pagoHora = 200)
    val operador = Trabajador("Operador", pagoHora = 10)
    val contador = Trabajador("Contador", pagoHora = 50)
    init {
        gerente.addHours(200)
        operador.addHours(230)
        contador.addHours(200)
    }
}