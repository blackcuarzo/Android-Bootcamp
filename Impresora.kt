class Impresora:IImpresora {
    override fun imprimirRecibo(cliente: Cliente, cuadroFactura: CuadroFactura, descuento: Double) {
        println("${cliente.getName()} \n${cliente.getAddress()}\n")
        System.out.printf("%-15s%-10s%-10s%-10s%n","Articulo","Cantidad","Precio","Total")
        System.out.printf("%-15s%-10s%-10s%-10s%n","--------","--------","--------","--------")
        var subtotal = 0.0
        for (item in cuadroFactura.lineasRecibo.keys){
            val cantidad =  cuadroFactura.lineasRecibo[item]!!.first
            val precio = cuadroFactura.lineasRecibo[item]!!.second
            val precioLinea = cantidad * precio
            System.out.printf("%-15s%-10s%-10s%-10s%n",item,cantidad,precio,precioLinea)
            subtotal += precioLinea
        }
        println("\n\nSubtotal:\t$subtotal")
        val total = subtotal - (subtotal*descuento/100)
        println("Descuento:\t$descuento%")
        println("Total:\t\t$total")
    }

}