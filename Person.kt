class Person (val firstName:String = "Peter", val lastName:String = "Parker") {

    var nickname:String? = null
        set(value) {
            field = value
            println("The new nickname is $value")
        }
        get() {
            println("The returned value is $field")
            return field
        }
    fun sayHello(){
        println("Hello $firstName ($nickname) $lastName")
    }
}