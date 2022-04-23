class Person (val firstName:String = "Peter", val lastName:String = "Parker") { //Here the class is constructed with default values
    fun sayHello(){
        println("Hello $firstName $lastName")
    }
}