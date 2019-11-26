package mykotlin

import kotlin.properties.Delegates

val myName: String by lazy {
    println("in myName")
    "Kotlin"
}

fun main() {
    val goods = Goods()
    goods.price = 900
    goods.price = 1000

    val customer = Customer(mapOf("name" to "Gil Dong", "age" to 30))
    println("${customer.name}, ${customer.age}")
}

class Goods {
    var price: Int by Delegates.observable(1000, { prop, old, new ->
        if( new > old) {
            println("가격이 올랐어요.")
        }else if( new < old) {
            println("가격이 내렸어요.")
        }
    })
}

class Customer(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

