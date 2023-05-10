class Review0510 {
}

fun main() {

    fun sum(no: Int): Int {
        var sum = 0 //타입이 추론이 되면 생략가능.
        for (i in 1..no) {
            sum = +i
        }
        return sum
    }
    val result = sum(10)
    println("result 의 결과 값은 : $result")

    /*----------------------------------------------*/

    val num3 : Any = "홍길동" //Any -> Object 와 비슷
    println(num3)

    /*----------------------------------------------*/

    fun sum2(no1:Int, no2:Int){ //Unit 생략 -> 자바의 void
        val result = no1 + no2
        println("no1 + no2 = $result")
    }
    sum2(10,20)

    /*----------------------------------------------*/

    //null 허용 연산자 -> Nothing?
    fun sum1():Nothing?{
        return null
    }

    /*----------------------------------------------*/

    //함수의 매개변수에서는 기본값 선언이 가능
    fun some(data1: Int, data2: Int = 10): Int {
        return data1 * data2
    }

    println("some 함수 결과 : " + some(10))
    println("some 함수 결과 : " + some(10, 20))

    /*----------------------------------------------*/

    // 배열 -> 동일한 데이터 타입의 값 할당
    //Array(배열의 갯수, 초기값)
    // 람다식 문법 : {매개변수 -> 실행될 문장}
    val data1 : Array<Int> = Array(3,{0})
    println("data1의 0번째 값 조회 : ${data1[0]}")

    /*----------------------------------------------*/

    val data2 :IntArray = IntArray(3,{10})
    data2[0] = 100
    println("data2의 0번째 값 조회 : ${data2[0]}")

    /*----------------------------------------------*/

    val data3 = arrayOf<Int>(10,20,30)
    println("data3 array size : ${data3.size}")
    println("data3 array data : ${data3[0]},${data3[1]},${data3.get(2)}")

    /*----------------------------------------------*/

    var list = listOf<Int>(1,2,3)
    println("list size : ${list.size}")
    println("list data : ${list[0]},${list[1]},${list[2]}")

    /*----------------------------------------------*/

    //가변 리스트
    var mL = mutableListOf<Int>(1,2,3)
    mL.add(3,100)
    println("mL size : ${mL.size}")
    println("mL data : ${mL[0]},${mL[1]},${mL[2]}")
    println("mL data indext 3 : ${mL[3]}")

    /*----------------------------------------------*/

    //Map객체는 키와 값으로 이루어진 데이터 집합
    //Map 객체의 키와 값은 Pair 객체이용  또는 '키 to 값' 형태로 이용가능
    var map = mapOf<String, String>(Pair("one","hello"), "two" to "word")
    println("map size : ${map.size}")
    println("map data : ${map.get("one")} ${map.get("two")}")

    /*----------------------------------------------*/

    var data5 = 10
    var data6 = if(data5>0){
        println("표현식 확인")
        30
    }else{
        50
    }
    println("data6 : $data6")

    /*----------------------------------------------*/

    var data7 = 10
    when(data7){
        10 -> println("data7의 값은 10")
        20 -> println("data7의 값은 20")
        else -> {
            println("data7의 값은 ??")
        }
    }

    /*----------------------------------------------*/

    var data8 = "abc"
    when(data8){
        "10" -> println("data8의 값은 10")
        "abc" -> println("data8의 값은 abc")
        else -> {
            println("data8의 값은 ??")
        }
    }

    /*----------------------------------------------*/

    var data9 : Any = 8
    when(data9){
        is String -> println("data9의 값은 문자열 : $data9") //is -> 해당 타입이 맞는지
        in 1..10 -> println("data9의 값은 숫자 : $data9") //범위 연산자 in
        else -> {
            println("data9의 값은 ??")
        }
    }

    /*----------------------------------------------*/

    var data10 = 5
    val result10 = when{
        data10 < 10 -> "data10 < 10"
        else -> {
            "data10의 값은?"
        }
    }
    println("data10 조건으로 result10 출력 : $result10")

    /*----------------------------------------------*/

    //반복문 활용
    var data11 = arrayOf<Int>(1,2,3)
    for(i in data11.indices){
        print(data11[i])
        if(i !== data11.size-1) print(",")
    }
    println()

    /*----------------------------------------------*/

    fun sum10():Int {
        val result = 0
        for (i in 1..10) {
            var sum = 0
            var result = sum + i
            println("in을 사용한 반복문의 result 값은 : $result")
        }
        return result
    }
    sum10()

    /*----------------------------------------------*/

    fun sum11():Int {
        val result = 0
        for (i in 1 until 10) {
            var sum = 0
            var result = sum + i
            println("until을 사용한 반복문의 result 값은 : $result")
        }
        return result
    }
    sum11()

    /*----------------------------------------------*/

    fun sum12():Int {
        val result = 0
        for (i in 1..10 step 2) {
            var sum = 0
            var result = sum + i
            println("step을 사용한 반복문의 result 값은 : $result")
        }
        return result
    }
    sum12()

    /*----------------------------------------------*/

    fun sum13():Int {
        val result = 0
        for (i in 10 downTo 1) {
            var sum = 0
            var result = sum + i
            println("downTo를 사용한 반복문의 result 값은 : $result")
        }
        return result
    }
    sum13()

    /*----------------------------------------------*/

    var data12 = arrayOf<Int>(1,2,3)
    for(i in data11.indices){
        print(data11[i])
        if(i !== data11.size-1) print(",")
    }
    println()







}