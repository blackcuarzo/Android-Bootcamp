
class Orquestador {
    private val presentador = Presentador()
    init{
        mostrarRespuesta(presentador.solicitarRespuesta("999"))
    }

    fun run(){
        mostrarRespuesta(presentador.solicitarRespuesta(readln()))
    }
    private fun mostrarRespuesta(mensaje:String){
        if(mensaje!="Fin") {
            mensaje.imprimir()
            run()
        }else {
            "Muchas Gracias".imprimir()
        }
    }
    private fun String.darFormato():String{
        return this.toByteArray().toString(charset("ISO-8859-1"))
    }

    private fun String.imprimir(){
        println(this.darFormato())
    }

}

