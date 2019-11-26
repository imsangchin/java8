package mykotlin

fun main() {

    //plus 함수 사용
    calcBox(1, 2, ::plus).also {
        //값 출력
        println(it)
    }
    //minus 함수 사용
    calcBox(1, 2, ::minus).also {
        //값 출력
        println(it)
    }
    //익명 함수 사용
    calcBox(1, 2, {
        //값 출력
        a, b -> a * b
    }).also {
        println(it)
    }


    //plus 함수 사용
    calcBox(1, 2, ::plus)
    //minus 함수 사용
    calcBox(1, 2, ::minus)
    //익명 함수 사용
    calcBox(1, 2, {
        //값 출력
        a, b -> a * b
    })
}

fun calcBox(a: Int, b: Int, formular: (Int, Int) -> Int): Int {
    return formular.invoke(a, b); // or formular(a,b)
}

fun plus(a: Int, b: Int) = a + b
fun minus(a: Int, b: Int) = a - b
