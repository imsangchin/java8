package mykotlin

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException

/**
 * https://www.xenonstack.com/blog/kotlin-andriod/
 * 절차적 프로그래밍/프로시저 설명 https://namu.wiki/w/%EC%A0%88%EC%B0%A8%EC%A0%81%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D
 *
 * 메소드 vs 함수
 * https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-vs-method-vs-procedure-c0216642ee87
 *
 * 비교표
 * https://hackr.io/blog/kotlin-vs-java
 *
 * 코틀린 in/out
 * https://thdev.tech/kotlin/androiddev/2017/10/03/Kotlin-Generics/
 *
 * 코틀린 문법 리뷰
 * https://kotlinlang.org/docs/reference/
 */

fun main(args: Array<String>) {
    val useKot = UseKotlin()
    useKot.__testException()
}

class UseKotlin {
    fun __testException() {
        val name: String? = null
        val s = name ?: fail("Name required")
        println(s)
    }

    fun fail(message: String): Nothing {
        throw IllegalAccessException(message)
    }
}