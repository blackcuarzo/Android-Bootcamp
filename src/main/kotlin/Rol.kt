interface IRoles{
}

enum class Rol (val pagoHora:Int):IRoles  {

    GERENTE(200),
    OPERARIO(10),
    CONTADOR(50);

    //internal var pagoHora:Int = 0
    internal var horasTrabajadas:Int = 0
/*
//    override fun sumarHoras (horas: Int){
//        horasTrabajadas += horas
//    }
//    override fun asignarPagoHora (_pagoHora: Int){
//        pagoHora = _pagoHora
//    }
 */

/*
//    companion object{
//        fun today(obj: DAYS): Boolean {
//            return obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
//        }
//        fun sum(hora: Int) {
//            imp.
//
//            obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
//        }
//    }

 */
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

fun Rol.selectorBono(){
    //var ganador:String?
    //Rol.values()
    val winer = Rol.values().reduce {
            ganador, trabajador ->   if(trabajador.horasTrabajadas > ganador.horasTrabajadas) trabajador else ganador
    }
    print(winer)
    for (rol in (Rol.values())){

    }
}


//fun Rol.asignarPagoHora (_pagoHora: Int){
//    pagoHora = _pagoHora
//}


enum class PaymentOption {
    CASH,
    CARD,
    TRANSFER
}

//fun PaymentOption.startPayment(transaction: Int) {
//    when (this) {
//        PaymentOption.CASH -> showCashPaimenxtInfo(transaction)
//        PaymentOption.CARD -> moveToCardPaymentPage(transaction)
//        PaymentOption.TRANSFER -> {
//            showMoneyTransferInfo()
//            setupPaymentWatcher(transaction)
//        }
//    }
//}