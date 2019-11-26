package mykotlin

fun <T> List<T>.midElement(): T {
    if (isEmpty()) {
        throw NoSuchElementException("List is Empty")
    }
    return this[size / 2]
}

val <T> List<T>.midIndex: Int
    get() = if( size == 0) 0 else size/2

// 확장 프로퍼티에는 Stored Property를 사용 불가
//val <T> List<T>.markIndex = 10

/**
 * backing field
 * https://medium.com/@nomanr/backing-field-in-kotlin-explained-9f903f27946c
 */
fun main() {
    var list = listOf(1, 2, 3, 4, 5)
    System.out.println(list.midElement())
    System.out.println(list.midIndex)

    printHello(ChildClass())
}

open class BaseClass
class ChildClass : BaseClass() {
    var number: Int = 10
        set(value) {
            if( value > 0) {
                field = value
            }
        }
}

fun BaseClass.sayHello() {
    println("BaseClass, Hello")
}
fun ChildClass.sayHello() {
    println("ChildClass, Hello")
}

fun printHello(base: BaseClass) {
    base.sayHello()
}