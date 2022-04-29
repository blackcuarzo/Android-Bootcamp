class CuadroFactura: ICuadroFactura {
    private var lineasRecibo = HashMap<String,Pair<Int,Double>>()
    override fun addLine(item:String,cantidad:Int,precio:String){
        //Añade el elemento a la tabla
        lineasRecibo[item] = Pair(cantidad,precio.toDouble())
    }
    override fun getEntradas():HashMap<String,Pair<Int,Double>>{
        return lineasRecibo
    }
}