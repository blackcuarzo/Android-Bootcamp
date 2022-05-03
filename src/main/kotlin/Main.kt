fun main(){
    val rol:Rol = Rol.values()[0]
    rol.asignarHoras()
    val admin = Orquestador()
    admin.run()
}