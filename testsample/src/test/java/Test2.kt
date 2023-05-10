class Test2 {
}



fun main(){
    fun sum(no:Int): Int{
        var sum = 0
        for(i in 1..no){
            sum =+ i
        }
        return sum
    }

    val name: String ="kkang"
    println("name : $name, sum : ${sum(10)}, plus : ${10+20}")
    
    //함수의 매개변수에서는 기본값 선언이 가능
    fun some(data1: Int, data2: Int = 10): Int{
        return data1 * data2
    }
    println(some(10))
    println(some(10,20))

    val num3 : Any = "이상용" // Any, Object와 비슷.
    fun sum2(no:Int, no2:Int) { // Unit, 자바 : void 생략
        val result = no + no2
        println("no + no2 = $result")
    }
    sum2(no = 10, no2 = 20)

    val data1:Array<Int> = Array(3, {10})
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30) //배열에서 두번째를 30으로 설정

    println(" array size : ${data1.size}")
    println(" array data : ${data1[0]},${data1[1]},${data1.get(2)}")

    val data2 = arrayOf<Int>(100,200,300) //크기가 3인 int 배열 선언 후 값 할당
    println("array size : ${data2.size}")
    println("array data : ${data2[0]},${data2[1]},${data2.get(2)}")

    var mutableList = mutableListOf<Int>(10,20,30)
    mutableList.add(3,40)
    mutableList.add(0,50)
    println("List size : ${mutableList.size}")
    println("List data : ${mutableList[0]},${mutableList.get(1)},${mutableList.get(2)},${mutableList.get(3)}, ${mutableList.get(4)}")
    
    //Map객체는 키와 값으로 이루어진 데이터 집합
    //Map 객체의 키와 값은 Pair 객체이용  또는 '키 to 값' 형태로 이용가능
    var map = mapOf<String, String>(Pair("one", "hello"), "two" to "word")
    println("map sizw : ${map.size}")
    println("map data : ${map.get("one")}, ${map.get("two")}")

    var data3 = 10
    if(data3 > 0){
        println("data3 > 0")
        true
    }else{
        println("data <= 0")
        false
    }

    //조건문 when
    var data4 = 10
    when (data4){
        10 -> println("data4 is 10")
        20 -> println("data4 is 20")
        else -> {
            println("data4 is not valid data")
        }
    }

    var data5:Any = 10
    when(data5){
        is String -> println("data5 is String")
        20, 30 -> println("data5 is 20 or 30")
        in 1..10 -> println("data5 is 1..10")
        else -> println("data5 is not valid")
    }

}