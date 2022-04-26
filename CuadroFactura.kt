class CuadroFactura: ICuadroFactura {
    var lineasRecibo = HashMap<String,Pair<Int,Double>>()
    override fun addLine(item:String,cantidad:Int,precio:String){
        //Añade el elemento a la tabla
        lineasRecibo[item] = Pair(cantidad,precio.toDouble())
    }
}