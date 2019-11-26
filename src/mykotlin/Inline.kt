package mykotlin

/**
 * inline 사용예
 */
inline fun myCalc(a: Int, b: Int, noinline calcFunc: (Int, Int) -> Int): Int {
    return calcFunc(a, b)
}

fun main(args: Array<String>) {
    val value = myCalc(10, 20, {
        a, b -> a * b
    })
    println(value)
}

