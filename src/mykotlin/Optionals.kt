package mykotlin


fun main() {

    testCart()
}

fun testNullables() {
    //옵셔널 변수 선언
    var nullableStr: String? = "abc"
    // 널 할당 가능
    nullableStr = null

    var str: String = "def"
    // str = null // 컴파일 에러 발생
}

fun nullCheck() {
    var nullableStr: String? = "abc"
    // println("Length of text is ${nullableStr.length}") //컴파일 오류 발생

    //if문을 사용해서 널 체크
    if (nullableStr != null) {
        //smart cast가 되어서, nullableStr은 자동으로 unwrap 되어짐
        println("Length of text is ${nullableStr.length}")
    } else {
        println("Text is null")
    }
}


fun testCart() {

    var str: String?  = null
    println(str?.length)

    str = "Hello"
    println(str?.length)


    var shopItem: ShopItem? = null
    println(shopItem?.seller?.tel) //판매자의 전화 번호 출력

    shopItem = ShopItem("새우깡", 1_000)
    println(shopItem?.seller?.tel) //판매자의 전화 번호 출력

    shopItem.seller = Seller("id_00000", "010-xxx-xxxx")
    println(shopItem?.seller?.tel) //판매자의 전화 번호 출력



}

/**
 * 상품
 */
class ShopItem(var name: String, var price: Int) {
    var seller: Seller? = null
}

/**
 * 판매자
 */
class Seller(var id: String, var tel: String)
