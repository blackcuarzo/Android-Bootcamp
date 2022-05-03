fun main(){
    //val admin = Orquestador()
    //admin.run()


    println(Rol.CONTADOR.horasTrabajadas)
    println(Rol.OPERARIO.horasTrabajadas)

    val rol:Rol = Rol.values()[0]
    rol.asignarHoras()
    rol.selectorBono()
    //Rol.selectorBono()
}