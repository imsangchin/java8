package mykotlin

import kotlinx.coroutines.*

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
 *
 * delegated property
 * https://proandroiddev.com/delegation-in-kotlin-e1efb849641
 * https://kotlinlang.org/docs/reference/delegated-properties.html
 * https://androidtest.tistory.com/113
 *
 * getter /setter
 * https://hongku.tistory.com/347
 *
 * 커스터 get / set
 * https://medium.com/@agrawalsuneet/property-getter-and-setter-kotlin-d89a3e70e62
 *
 * 옵셔널 체이닝
 * https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30
 *
 * let 함수
 * https://qiita.com/ngsw_taro/items/d29e3080d9fc8a38691e
 *
 * Smart Cast
 * https://kotlinlang.org/docs/reference/typecasts.html?_ga=2.189228459.1828526368.1575005551-1360689027.1517380889#smart-casts
 */

fun main(args: Array<String>) {
    val useKot = UseKotlin()
    // useKot.__testException()
    //println(useKot.sum(1, 2))
    useKot.useCoroutine()
}

class UseKotlin {
    fun __testException() {
        val name: String? = null
        val s = name ?: fail("Name required")
        println(s)

        useCoroutine()

        //Destructuring Declaration
        val (title, price) = Book("java", 1000)
        println("$title, $price")
    }

    /**
     * Nothing 사용예
     */
    fun fail(message: String): Nothing {
        throw IllegalAccessException(message)
    }

    /**
     * 함수를 단일식으로 기술 가능
     */
    fun sum(a: Int, b: Int) = a + b

    /**
     * 코루틴
     */
    fun useCoroutine() {
        //코루틴을 사용해서, 문구를 10번 출력
        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(10) {
                delay(1000L)
                println("$it> 난 코루틴에서 동작중")
            }
        }

        runBlocking {
            //이전 작업이 종료될때까지 대기
            job.join()
        }
    }


    /**
     * 데이터 클래스
     */
    data class Book(var title: String, var price: Int)


    /**
     * sealed 클래스
     */
    sealed class MyBook {
        val name: String = ""
        fun print(): String {
            return "Name: $name"
        }

        abstract fun getPrice(): Int
        class ComicBook : MyBook() {
            override fun getPrice(): Int {
                return 1000
            }
        }
        class ComputerBook : MyBook() {
            override fun getPrice(): Int {
                return 2000
            }
        }
    }
}

