class Test3 {
}

fun main() {

    //고차함수 사용예제 -> 매개변수 또는 결과값 자리에 함수가 들어가는 형태
    fun testH(arg:(Int)->Boolean):()->String{
        val result = if(arg(10)){
            "valid"
        }else {
            "invalid"
        }
        return {"testH result 확인 : $result"}
    }

    //고차함수 사용예제
    val result16 = testH({ no -> no > 0 })
    println("result16의 값 조회 : ${result16()}")

}
