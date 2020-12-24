package com.easy.kotlin

/**
 * Created by jack on 2017/7/9.
 */

object FPBasics {

    //最简单的声明和返回值定义
    fun double(x: Int): Int {
        return 2 * x
    }

    //(Int)->Int是函数类型的声明，表示一个从Int映射到Int的函数？？？？？
    fun triple(double: (Int) -> Int): (Int) -> Int {
        //函数体
        return { x -> double(x) + x }
    }

    //使用的时候 我们需要声明一个函数字面量
    val double = fun(x: Int): Int = x + x
    //然后这样调用
//    triple(double)(2)  //=4

    //函数用法
    //1.     val ddd= double(1)

    //2.      类A.函数


    //扩展函数
    fun String.swap(index1: Int, index2: Int): String {
        val charArray = this.toCharArray()
        val tmp = charArray[index1]
        charArray[index1] = charArray[index2]
        charArray[index2] = tmp

        return charArrayToString(charArray)
    }

    fun charArrayToString(charArray: CharArray): String {
        var result = ""
        charArray.forEach { it -> result = result + it }
        return result
    }


    //中缀函数  适用于成员函数 或者扩展函数    只有一个参数    用infix关键字修饰
//    infix fun Int.shl(x:Int):Int{    //
//        xxx
//    }


    //参数由  number: Int 这种形式指定
    fun powerOf(number: Int, exponent: Int): Int {
        return Math.pow(number.toDouble(), exponent.toDouble()).toInt()
    }


    //可以有默认值  x: Int = 0        当复写此方法时 默认值不能带有默认值
    fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }


    //使用默认值
    fun reformat(str: String,
                 normalizeCase: Boolean = true,
                 upperCaseFirstLetter: Boolean = true,
                 divideByCamelHumps: Boolean = false,
                 wordSeparator: Char = ' ') {

    }


    //返回值为unit
    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
        // `return Unit` 或者 `return` 是可选的  可以不用显式返回
        return Unit()
    }

    //可以省略返回值  当是Unit时
    fun printHello2(name: String?) {
        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
        // `return Unit` 或者 `return` 是可选的  可以不用显式返回
        return
    }

    //当函数为一个表达式的时候，可以不用写{}
//    fun double(x: Int):Int=x+1
//    fun double(x: Int)=x+1

    //函数可以嵌套  可以在一个函数内部加入函数
    //局部函数可以访问外部函数的局部变量


    //5.匿名函数   不能在此方用
//    fun(x:Int):Int{
//        return x
//    }

    //6、lambda表达式
    //总是被{}
    //其参数(有的话)  在->之前申明（参数类型可以省略）
    //函数体（如果存在的话）  在->后面
//      var x:Int -> x+2


    //7.单个参数的隐式名称  it
    val list = listOf(1,2,3,4)
//    list.map{it+2}         函数字面量只有一个参数，那么它的声明可以省略(连同 ->),其名称是it



    //8.带接受者的函数字面量   使用指定的"接受者对象"调用函数字面值的功能，使用匿名函数的语法
    //我们可以直接指定函数字面值的接受者类型    接受者对象.()
    val sum = fun Int.(other: Int): Int = this + other

//    1.sum(1)
    //2


    //可变参数  vararg
    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }


    fun sum(x: Int, y: Int, z: Int): Int {
        val delta = 0;
        fun add(a: Int, b: Int): Int {
            return a + b + delta
        }
        return add(x + add(y, z))
    }


    fun sumGTZero(c: Iterable<Int>): Int {
        var sum = 0
        c.filter { it > 0 }.forEach {
            sum += it
        }
        return sum
    }


    fun isOdd(x: Int): Boolean {
        return x % 2 == 1
    }

    tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))


    fun test() {
        val doubleTwo = double(2)
        println("double(2) = $doubleTwo")

        val str = "abcd"
        val swapStr = str.swap(0, str.lastIndex)
        println("str.swap(0, str.lastIndex) = $swapStr")

        val eight = powerOf(2, 3)
        println("powerOf(2,3) = $eight")

        val zero = add()
        val one = add(1)
        val two = add(1, 1)
        println("add() = $zero")
        println("add(1) = $one")
        println("add(1, 1) = $two")

        printHello("Jack")

        println("sum(1,2,3) = ${sum(1, 2, 3)}")

        val list = listOf(1, 2, 3, 4, 5)
        list.filter(FPBasics::isOdd)

        list.filter((fun(x: Int): Boolean {
            return x % 2 == 1
        }))

        list.filter {
            it % 2 == 1
        }

        list.filter({
            it % 2 == 1
        })

        val sumgtZero = FPBasics.sumGTZero(list) //
        println("sumgtZero = $sumgtZero")

//        带接收者的函数字面值
        val sum = fun Int.(other: Int): Int = this + other
        println("1.sum(1)=${1.sum(1)}")

        findFixPoint()

    }

}


open class DefaultParamBase {
    open fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }
}

class DefaultParam : DefaultParamBase() {
    override fun add(x: Int, y: Int): Int { // 不能有默认值
        return super.add(x, y)
    }
}


//带接收者对象的函数字面值
class HTML {
    fun body() {
        println("HTML BODY")
    }
}

//val sum = fun Int.(other: Int): Int = this + other
//println("1.sum(1)=${1.sum(1)}")
// 9.带接收者的函数字面值
//当接收者类型可以从上下文推断时  可以使用lambda表达式
fun method(init:HTML.() -> Unit): HTML { // HTML.() -> Unit 函数类型
    val html = HTML()  // 创建接收者对象
    html.init()        // 将该接收者对象传给该 lambda
    return html
}

//fun main(args: Array<String>) {
////    FPBasics.test()
//    method { body() }
//
//
//}


