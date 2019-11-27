package mykotlin

class GoodsDeal(var name: String, var price: Int) {

    /**
     * computed property로 불리며, 해당 프로퍼티에 접근시, (매번) 커스텀 get가 호출된다.
     */
    val isFree: Boolean
        get() = if (price == 0) true else false

    /**
     * 커스텀 get/set 사용예, readonly가 아니므로 val -> var로 선언
     */
    var displayInfo: String
        get() = "$name $price"
        set(value) {
            var array = value.split(" ".toRegex())
            if (array.size == 2) {
                name = array[0]
                price = array[1].toInt()
            }
        }

    var seller: String = "공룡전자"
        private set

    var discountPercent: Int = 0
        set(value) {
            if( value > 50) {
                throw IllegalArgumentException("할인율은 50%를 넘을수 없어요.")
            }
            field = value
        }
}


fun main() {
    val goods = GoodsDeal("coffee", 0)
    println("${goods.isFree}")
    goods.price = 100
    println("${goods.isFree}")


    val toy = GoodsDeal("카봇", 10_000)
    println(toy.displayInfo)
    toy.displayInfo = "또봇 20000"
    println(toy.displayInfo)


    val computer = GoodsDeal("컴퓨터", 1000_000)
    computer.discountPercent = 30
    println("${computer.discountPercent}")
    computer.discountPercent = 60
    println("${computer.discountPercent}")
}