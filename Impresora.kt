class Impresora:IImpresora {
    override fun imprimirRecibo(cliente: ICliente, cuadroFactura: ICuadroFactura, descuento: Double) {
        println("${cliente.getName()} \n${cliente.getAddress()}\n")
        System.out.printf("%-15s%-10s%-10s%-10s%n","Articulo","Cantidad","Precio","Total")
        System.out.printf("%-15s%-10s%-10s%-10s%n","--------","--------","--------","--------")
        var subtotal = 0.0
        for (item in cuadroFactura.getEntradas().keys){
            val cantidad =  cuadroFactura.getEntradas()[item]!!.first
            val precio = cuadroFactura.getEntradas()[item]!!.second
            val precioLinea = cantidad * precio
            System.out.printf("%-15s%-10s%-10s%-10s%n",item,cantidad,precio,precioLinea)
            subtotal += precioLinea
        }
        //Programación imperativa, usando reduce
        val subtotal2 = cuadroFactura.getEntradas().values.reduce{
            sum, pair -> Pair(1, sum.second*sum.first+ pair.second*pair.first)
        }.second
        //Programación imperativa, usando fold
        val subtotal3 = cuadroFactura.getEntradas().values.fold(0.0){
                sum, pair -> sum + pair.second*pair.first
        }
        println("\n\nSubtotal:\t$subtotal")
        println("Subtotal2:\t$subtotal2")
        println("Subtotal3:\t$subtotal3")
        val total = subtotal - (subtotal*descuento/100)
        println("Descuento:\t$descuento%")
        println("Total:\t\t$total")
    }

}