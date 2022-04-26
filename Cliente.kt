class Cliente:ICliente{
    //Principio solid de "Separation of concerns": Creacion clase client
    protected var nombre:String? = null // Encapsulamiento para evitar el acceso directo a la variable
    protected var direccion:String? = null

    fun getName(): String {
        return nombre ?: "El cliente no tiene razon social"
    }
    fun getAddress(): String {
        return direccion ?: "NA"
    }
    override fun addName(nombre:String){
        this.nombre = nombre
    }
    override fun addAddress(direccion:String){
        this.direccion = direccion
    }
}