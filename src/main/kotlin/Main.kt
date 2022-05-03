fun main(){
    //val admin = Orquestador()
    //admin.run()


    println(Rol.CONTADOR.horasTrabajadas)
    println(Rol.OPERARIO.horasTrabajadas)

    val rol:Rol = Rol.values()[0]
    rol.asignarHoras()
    rol.selectorBono()
    println(Rol.GERENTE.calcularSalario())
    println(Rol.OPERARIO.calcularSalario())
    println(Rol.CONTADOR.calcularSalario())
    //Rol.selectorBono()
}