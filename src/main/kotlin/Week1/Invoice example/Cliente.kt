class Cliente:ICliente{
    //Principio solid de "Separation of concerns": Creación clase client
    private var nombre:String? = null // Encapsulamiento para evitar el acceso directo a la variable
    private var direccion:String? = null

    override fun getName(): String {
        return nombre ?: "El cliente no tiene razon social"
    }
    override fun getAddress(): String {
        return direccion ?: "NA"
    }
    override fun addName(nombre:String){
        this.nombre = nombre
    }
    override fun addAddress(direccion:String){
        this.direccion = direccion
    }
}