
class Orquestador {
    private val presentador = Presentador()

    fun run(){
        presentador.atenderEstado(Estados.INICIO)
        presentador.solicitarRespuesta(readln().toInt())
    }

}

