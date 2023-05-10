// 최상위 영역
// java : int num = 1;
// 코트린 : val(or var) 변수명 : 타입 = 값
// 깃 사용시 주의사항.
// 1. 학원, 2.집, 3. 깃 원격지
// 항상 어디가 최신인지 알아야함.
val num : Int = 1
// 우리가 왜 IDE를 사용하나요?
// 편의성. 기본적인 문법 체크를 해줍니다.
// 문법에 다 외울려고 안했으면 합니다.
// 최소한 기본 문법 정도만 알고, 진행하자.
// 통계적으로 접근해라. -> 일단, 많이 자주 사용하는 것부터 시작.
// 최상위 영역에서는 선언만 하면 오류가 난다.
// 일단 IDE 문법 체크를 최대한 이용하자
// val num2 : String;
class test {
}

//주 생성자가 생략이 되었고, 보조생성자를 사용
class User{
    var name = "홍길동"
    //코틀린의 생성자는 키워드가 따로 존재함.
    //보조생성자 : constructor
    constructor(name : String){
        this.name = name
    }
    fun someFun(){
        println("name:$name")
    }
}

class User2(val name:String, count:Int){
    //주 생성자의 자역변수 name
    //주 생성자는 calss 이름 옆에 선언이 되고 constructor를 생략

    //클래스 멤버변수 name -> val name:String
   // var name ="홍길동" = val name:String
    init {
        //init 함수 안에서는 주 생성자의 매개변수를 사용가능
        // class 멤버변수로는 사용이 불가능 ex) var name ="홍길동"
        println("init 호출. 주 생성자 매개변수 사용 : $name ")
    }
    fun someFun(){
        println("클래스 멤버변수 name 호출 : $name ")
    }
}
//주 생성자 생략 -> 디폴트 생성자를 만들어줌, 보조 생성자 이용
//주생성자와 보조생성자가 같이 있을 경우 보조생성자에서 주생성자로 연결하는 부분 필요 -> this
//보조생성자 보다 주생성자 이용
class User3(name: String){
    constructor(name:String, count: Int) : this(name){
    }
}

// 상속 할 때 부모 클래스에 open 키워드 필요
open class Super{
    open var superData = 10
    //접근 지정자 protected 확인 -> 자식클래스에서만 부모 클래스 멤버에 접근가능 즉, main함수에서 접근 불가
    protected var protectedData = 20
    open fun superFun(){
        println("superFun 호출")
    }
}
//상속 할 때 부모클래스의 초기화가 필요함 -> Super() 주 생성자 호출 해야함
class Sub : Super(){
    //부모의 멤버변수를 재정의 해서 사용
    // var superData = 20 -> 키워드 open과 오버라이드가 없어서 이런식은 안됨
    override var superData = 20
    override fun superFun(){
        //자식클래스에서 protected 변수 접근 가능
        protectedData++
        println("자식에서 재정의 :  $superData " )
    }
}

//데이터 클래스 아님
class NonDataClass(val name: String, val pw : String){
    lateinit var email : String
    constructor(name:String, pw:String, email:String):this(name,pw){
        this.email = email  
    }
}
//데이터 클래스 -> 실제 값을 비교해주는 변수는 주 생성자의 변수만 가능
data class DataClass(val name: String, val pw : String, val email:String){
/*    lateinit var email : String
    constructor(name:String, pw:String, email:String):this(name,pw){
        this.email = email
    }*/
}

open class Super2{
    open var data = 10
    open fun some(){
        println("i am Super2 : $data")
    }
}
//object 타입 지정안하면 기본 Any
val obj = object : Super2() {

    override  var data = 20
    override fun some(){
            println("i am Super2 재사용 한 값 : $data")
        }
    }
// 자바의 static 키워드와 동일한 기능 -> 멤버에 접근시 클래스명에 점을 찍고 접근
class companionClassTest{
    companion object {
        var data = 10
        fun some(){
            println("companion object data의 값 :  $data ")
        }
    }
}

//고차함수 사용예제 -> 매개변수 또는 결과값 자리에 함수가 들어가는 형태
fun testH(arg:(Int)->Boolean):()->String{
    val result = if(arg(10)){
        "valid"
    }else {
        "invalid"
    }
    return {"testH result 확인 : $result"}
}

fun main() {
    //?null 허용 연산자 및  null 허용 변수 호출
    // ? : 엘비스 연산자 : null 이 아니면 아닌 값 호출
    // ?. null 허용 변수 호출 : 접근시 반드시 ?. 접근
    //null 이면 지정한 기본값이 할당
    val data20:String? = "홍길동"
    println("data20의 길이 : ${data20?.length ?:0}")
    //null이면 0출력 null이면 길이 출력->3

    //고차함수 사용예제
    val result16 = testH({no -> no > 0})
    println(result16())
    println("result16의 값 조회 : ${result16()}")

    val some2 = {no1:Int, no2:Int -> println("출력")
    no1 * no2
    }
    println("익명함수 출력 확인 some(1,2): ${some2(1,2)}")

    //매개변수가 1하나인 람다식(익명함수) 매개변수로 출력
    val result14 = {no1:Int -> println("no1 값 출력 : $no1") }
    val y = result14(100)

    //매개변수가 1하나인 람다식(익명함수), it으로 대체
    //함수 타입 -> 결과 값의 타입을 생략하다면 Unit(void)이 디폴트
    //자동변환시, 매개변수가 1개인 경우 it으로 바로 대체
    //(Int)->Unit 결과값 없음 정의
    val result15 : (Int)->Unit = { println("result15 값 it으로 출력 : $it") }
    val z = result15(200)


    fun some(no1:Int, no2:Int):Int{
        return no1+no2
    }
    // 람다식 익명함수 , 왼쪽 : 매개변수, -> 오른쪽 : 수행문장
    val result13 = {no1:Int, no2:Int -> no1+no2}
    val x = result13(1,2)
    println("result13의 매개변수를 더 한 x의 값 : $x")



    //companionClass사용예제
    companionClassTest.data
    companionClassTest.some()
    
    //object 익명클래스 사용예제
    obj.data=20
    obj.some()
    
    //실제 값이 아닌 주소값 비교
    val none1 = NonDataClass(name="홍길동", pw="1234")
    val none2 = NonDataClass(name="홍길동", pw="1234")
    println("none1의 주소값 :  $none1")
    println("none2의 주소값 :  $none2")
    println( "equals를 이용한 값 비교 : ${none1.equals(none2)} ") //false

    //데이터 클래스의 실제 값 비교
    // 보조생성자의 변수 email 은 비교하지 않음
    //email을 주생성자에 추가한 후 비교 -> false 출력
    val data13 = DataClass(name="홍길동", pw="1234", email = "email1")
    val data14 = DataClass(name="홍길동", pw="1234", email = "email2")
    println("data13의 실제값 :  $data13")
    println("data14의 실제값 :  $data14")
    println( "equals를 이용한 값 비교 : ${data13.equals(data14)} ") //true
    
    

    val obj = Sub()
    println( "obj.superData 값 : " + obj.superData)
    obj.superFun()
    //main에서 protected 변수 접근 불가 -> obj.protectedData

    val user2 = User2(name="홍길동", count=10)
    println("User2 사용 : " + user2)


    //객체 생성, 인스턴스 생성
    //자바  : User user = new User
    //코틀린
    val user = User(name = "이순신")
    println("someFun()함수사용 name : " + user.name)
    user.someFun()

    //반복문 활용
    var data12 = arrayOf<Int>(1,2,3)
    for((index,value ) in data12.withIndex()){
        print("인덱스의 값 : ")
        print(index)
        print("value의 값 : ")
        print(value)
        if(index !== data12.size-1) print(",")
    }
    println()

    fun sum10 ():Int {
        val result = 0
        for(i in 1 until 10){
            val sum = 0
            val result = sum + i
            println("반복문 result 값은 : $result")
        }
        return result
    }
    sum10()

    fun sum11 ():Int {
        val result = 0
        for(i in 1..10 step 2){
            val sum = 0
            val result = sum + i
            println("반복문 result 값은 : $result")
        }
        return result
    }
    sum11()

    var data11 = arrayOf<Int>(1,2,3)
    for(i in data11.indices){
        print(data11[i])
        if(i !== data11.size-1) print(",")
    }
    println()

    var data10 = 5
    val result10 = when{

        data10 < 10 -> "data10 < 10"
        else -> {
            "data10의 값은??"
        }
    }

    println("data10 조건으로 result10 출력하기 : $result10")


    var data9 : Any =  5
    when (data9) {
        // is 해당 타입이 맞는지 확인.
        is String -> println("data9의 값은 문자열 : $data9")
        "10" -> println("data8 is 10")
        in 1 .. 10 -> println("data9의 값은 숫자 : $data9")
        "abc" -> println("data8 is abc")
        else -> {
            println("data is not valid data9")
        }
    }

    //=================================================================
    var data8 = "abc"
    when (data8) {
        "10" -> println("data8 is 10")
        "abc" -> println("data8 is abc")
        else -> {
            println("data is not valid data8")
        }
    }
    var data6 = 10
    when (data6) {
        10 -> println("data6 is 10")
        20 -> println("data6 is 20")
        else -> {
            println("data is not valid data6")
        }
    }

    //==============================================================
    var data5 = 10
    var result = if(data5 > 0) {
        println("data > 0")
        true
    } else {
        println("data <= 0")
        false
    }
    println(result)

    //============================================================
    var map = mapOf<String, String>(Pair("one", "hello"), "two" to "2")
    println("""
       map size : ${map.size}
       map data 인덱스 3 : ${map.get("one")}, ${map.get("two")}
    """.trimIndent())

    //===================================================================
    // 가변리스트 확인
    var mL = mutableListOf<Int>(1,2,3)
    mL.add(3, 100)
    println("""
       mL size : ${mL.size}
       mL data 인덱스 3 : ${mL[3]}
    """.trimIndent())

    var list = listOf<Int>(1,2,3)
    // 불변 리스트 변경 불가.
    //list[0] = 100
    println("""
       list size : ${list.size}
       list data : ${list[0]}, ${list[1]}, ${list[2]}
    """.trimIndent())

    //=====================================================================
    var data4 = intArrayOf(1,2,3)
    val data3 = arrayOf<Int>(1,2,3)

    var data2 : IntArray = IntArray(3, {0})
    data2[0] = 100
    println("data1의 값 조회 : ${data2[0]}")
//========================================================================
    // 배열 -> 자바 : 동일한 데이터 타입의 값들을 할당함.
    // 비교 vs 자바스크립트 : 여러 가지의 데이터 타입의 값들을 할당함.
    // Array(배열의 갯수, 초깃값
    // 람다식은 문법이 : { 매개변수 -> 실행될 문장 }
    // 람다식에서 매개변수가 1개면 화살표, 매개변수를 생략
    // : { 실행될 문장. }
    val data1:Array<Int> = Array(3, { 0 })
    println("data1의 값 조회 : ${data1[0]}")
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30)

    println("""
        array size : ${data1.size}
        array data : ${data1[0]}, ${data1[1]}, ${data1.get(2)}
    """
    )
    //==================================================================
    // 함수의 매개변수에서는 var, val 키워드 사용하면 안됌.
    // 자동으로 val가 들어가 있다.
    fun sum3(no:Int, no2:Int) { // Unit, 자바 : void 생략
        val result = no + no2
        println("no + no2 = $result")
    }

    //======================================================================
    // 함수의 결과값의 타입을 Nothing
    fun some1():Nothing? { // ?는 null 혀용이 가능한 연산자.
        return null
    }

    // -----------------------------------------------------------------
    val num3 : Any = "이상용" // Any, Object와 비슷.
    fun sum2(no:Int, no2:Int) { // Unit, 자바 : void 생략
        val result = no + no2
        println("no + no2 = $result")
    }
    sum2(no = 10, no2 = 20)

    //-------------------------------------------------------------------
    fun sum(no : Int) : Int{
        // 타입이 추론이 되면, 생략가능.
        var sum = 0
        for(i in 1..no){
            sum += i
        }
        return sum
    }
    val name:String = "kkang"
    println("name : $name, sum : ${sum(10)}, plus:${10+20}")
    println("Hello World")
    println("num의 값 : $num")
}