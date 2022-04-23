class Person (val _firstName:String, val _lastName:String) {
    val firstName = _firstName
    val lastName = _lastName
    fun sayHello(){
        println("Hello $firstName $lastName")
    }
}