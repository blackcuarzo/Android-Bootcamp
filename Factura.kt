interface IFacturador{
    fun addClientInfo(nombre: String,direccion: String)
    fun addLine(item:String,cantidad:Int,precio:String)
    fun imprimirRecibo()
    fun addDescuento(descuento: Double)

}
interface ICliente{
    fun addName(nombre:String)
    fun addAddress(direccion:String)
}

interface IImpresora{
    fun imprimirRecibo(cliente: Cliente,cuadroFactura:CuadroFactura,descuento:Double){}
}

interface ICuadroFactura{
    fun addLine(item:String,cantidad:Int,precio:String)
}

class Facturador():IFacturador {
    private var descuento:Double = 0.0
    private var cliente = Cliente()
    private val cuadroFactura = CuadroFactura()
    private val impresora = Impresora()

    override fun addClientInfo(nombre: String,direccion: String){
        cliente.addName(nombre)
        cliente.addAddress(direccion)
    }
    override fun addLine(item:String,cantidad:Int,precio:String){
        //Añade el elemento a la tabla
        cuadroFactura.addLine(item,cantidad,precio)
    }

    override fun imprimirRecibo(){
        impresora.imprimirRecibo(cliente,cuadroFactura,descuento)
    }
    override fun addDescuento(descuento: Double){
        this.descuento = descuento
    }
}
fun main(){
    val facturador = Facturador()
    facturador.addClientInfo("Tienda Química", "Medellin, Cll 58B - 17")
    facturador.addLine("Tostador",3,"10")
    facturador.addLine("Mesa",1,"30")
    facturador.addDescuento(10.0)
    facturador.imprimirRecibo()
}