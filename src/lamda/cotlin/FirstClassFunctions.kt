package lamda.cotlin

fun main(args: Array<String>) {

    __testFirstClassFun1()
}

/**
 * 일급함수 (First-class functions)
 *
 * 1. 일급함수는 함수가 객체로 취급될 수 있습니다.
 * 2. 일급함수는 함수 객체를 인자로 넘길 수 있어야 합니다.
 * 3. 일급함수는 함수 객체를 인자로 넘길 수 있어야 합니다.
 */
fun __testFirstClassFun1() {
    val helloFunPtr: () -> String = { "hello world" }
    println(helloFunPtr())
    printFunction(helloFunPtr)
}

fun printFunction(func: () -> String) {
    print("출력: ${func()}")
}