package com.easy.kotlin

/**
 * Created by jack on 2017/7/9.
 */

class TailRecDemo {
    fun fact(n: Int): Long {
        if (n == 0) return 1
        return n * fact(n - 1)
    }

//尾递归计算余弦 用tailrec来修饰
    tailrec fun findFixPoint(x: Double = 1.0): Double
            = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))
//函数必须将其自身调用作为它执行的最后一个操作
    //不能在try catch中使用，在递归调用后有更多代码 不能使用尾递归


    fun test() {
        fact(100)
        findFixPoint()
    }
}

fun main(args: Array<String>) {
    TailRecDemo().test()
}
