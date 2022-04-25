class Factura() {
    var descuento:Double = 0.0
    var lineasRecibo = HashMap<String,Pair<Int,Double>>()
    var nombre = ""
    var direccion = ""
    fun imprimirRecibo(){
        println("${nombre} \n${direccion}\n")
        System.out.printf("%-15s%-10s%-10s%-10s%n","Articulo","Cantidad","Precio","Total")
        System.out.printf("%-15s%-10s%-10s%-10s%n","--------","--------","--------","--------")
            var subtotal = 0.0
        for (item in lineasRecibo.keys){
            val cantidad =  lineasRecibo[item]!!.first
            val precio = lineasRecibo[item]!!.second
            val precioLinea = cantidad * precio
            System.out.printf("%-15s%-10s%-10s%-10s%n",item,cantidad,precio,precioLinea)
            subtotal += precioLinea
        }
        println("\n\nSubtotal:\t$subtotal")
        val total = subtotal - (subtotal*descuento/100)
        println("Descuento:\t$descuento%")
        println("Total:\t\t$total")
    }
    fun addLine(item:String = "no value",cantidad:Int,precio:String){
        //Añade el elemento a la tabla
        lineasRecibo.put(item,Pair(cantidad,precio.toDouble()))
    }
}
fun main(){
    val factura = Factura()
    factura.nombre = "Tienda Quimica"
    factura.direccion = "Medellin, Cll 58B - 17"
    factura.addLine("Tostador",3,"10")
    factura.addLine("Mesa",1,"30")
    factura.descuento = 10.0
    factura.imprimirRecibo()
}