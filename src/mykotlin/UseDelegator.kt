package mykotlin

import kotlin.reflect.KProperty


/**
 * String 클래스를 확장하지 않고, 위임(Delegation)으로 기능 추가함
 */
class MyPassword(val base: String) : CharSequence by base,
        Comparable<String> by base {

    /**
     * 글자수는 6자 이상이어야 한다.
     */
    fun isValidLength(): Boolean {
        return if(base.length > 6) true else false
    }
}

fun main(args: Array<String>) {

    val password = MyPassword("1234")

    //기존 메소드
    println("get(0)= ${password.get(0)}")
    println("length= ${password.length}")

    //추가한 메소드
    println("password validation is ${password.isValidLength()}")

    //실행
    val item = MyGameItem()
    item.exp = "설명"
    println(item.exp)
}


class MyGameItem {
    var exp: String by NameDelegate()
}

/**
 * Property Delegate는 getValue/setValue를 제공해야 한다.
 */
class NameDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}